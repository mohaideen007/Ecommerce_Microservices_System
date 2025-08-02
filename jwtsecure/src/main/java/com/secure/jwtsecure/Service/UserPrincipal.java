package com.secure.jwtsecure.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.secure.jwtsecure.Model.user_dao;

public class UserPrincipal implements UserDetails {

    private final user_dao user;

    public UserPrincipal(user_dao user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

     //   Set<role_dao> roles = user.getRoles();

     String role = user.getRole();
    if (role == null || role.trim().isEmpty()) {
        role = "USER";
    }
    List<SimpleGrantedAuthority> author = new ArrayList<>();
    author.add(new SimpleGrantedAuthority(role.trim()));
    return author;
}

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
