package com.secure.jwtsecure.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.secure.jwtsecure.Model.user_dao;
import com.secure.jwtsecure.Repo.secure_repo;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private secure_repo serrepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user_dao user=serrepo.findByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        else{
            return new UserPrincipal(user);
        }
    }

    

}
