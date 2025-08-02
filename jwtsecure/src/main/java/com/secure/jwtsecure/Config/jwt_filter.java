package com.secure.jwtsecure.Config;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.secure.jwtsecure.Service.MyUserDetailsService;
import com.secure.jwtsecure.Service.jwt_service;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class jwt_filter extends OncePerRequestFilter{

    @Autowired
    private jwt_service jwtservice;

    @Autowired
    private ApplicationContext applicationContext;

@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

            String path=request.getRequestURI();
            if(path.startsWith("/product-service/product/checkavailable")){
                filterChain.doFilter(request, response);
                return;
            }
    String authheader = request.getHeader("Authorization");
    String username = null;
    String token = null;
    if (authheader != null && authheader.startsWith("Bearer ")) {
        token = authheader.substring(7);
        username = jwtservice.extractusername(token);
    }
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        UserDetails userdetails = applicationContext.getBean(MyUserDetailsService.class).loadUserByUsername(username);

        if (jwtservice.validateToken(token, userdetails)) {

            String role=jwtservice.extractrole(token);
            List<GrantedAuthority> author=List.of(new SimpleGrantedAuthority(role));
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    userdetails,
                    null,
                    author
            );
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
    }
    filterChain.doFilter(request, response);
}
}
