package com.secure.jwtsecure.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.secure.jwtsecure.Model.user_dao;
import com.secure.jwtsecure.Repo.secure_repo;



@Service
public class jwt_service {

    @Autowired
    private secure_repo repo;


    @Value("${jwt.secret}")
    private String secretkey;

    public String generateToken(user_dao userdao) {

        Map<String, Object> claims = new HashMap<>();

        // List<String> roles = new ArrayList<>();

        
        // UserDetails userDetails =  new UserPrincipal(userdao);

        // for(GrantedAuthority r:userDetails.getAuthorities()){
        //     roles.add(r.getAuthority());
        // }

        String role= userdao.getRole();
        claims.put("scope", role);
        
       return Jwts.builder()
                .claims()
                .add(claims)
                .subject(userdao.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) 
                .and()
                .signWith(getKey())
                .compact();


    }

    private SecretKey getKey() {
        byte[] keybyte=Decoders.BASE64.decode(secretkey);
        return Keys.hmacShaKeyFor(keybyte);
    }



    public Claims extractallclaims(String token) {
        return Jwts.parser()
        .verifyWith(getKey())
        .build()
        .parseSignedClaims(token)
        .getPayload();
}

    public String extractusername(String token) {
       Claims claims=extractallclaims(token);
       return extractfromsubject(claims);
    }


    public String extractfromsubject(Claims claims) {
        return claims.getSubject();
    }
    public Date extractexpiration(String token) {
        Claims claims=extractallclaims(token);
        return extractexpirationfrom(claims);
    }


    public Date extractexpirationfrom(Claims claims) {
        return claims.getExpiration();
    }

    public boolean validateToken(String token, UserDetails userdetails) {
        String username=extractusername(token);
        return (username.equals(userdetails.getUsername()) && !isTokenExpired(token));
    }
    public boolean isTokenExpired(String token) {
        return extractexpiration(token).before(new Date());



    }

    public String extractrole(String token) {
       Claims claims=extractallclaims(token);
       return claims.get("scope", String.class);
    }
}

   