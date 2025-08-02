package com.secure.jwtsecure.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.secure.jwtsecure.Model.user_dao;
import com.secure.jwtsecure.Repo.secure_repo;

@Service
public class secure_service {

    @Autowired
    private secure_repo secrepo;

    @Autowired
    private AuthenticationManager authmanager;


   
    @Autowired
    private jwt_service jwt;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String getMethodName() {
        return "Hello from secure service";
    }

    public user_dao adduser(user_dao userdao) {
        userdao.setPassword(passwordEncoder.encode(userdao.getPassword()));
       
        userdao.setRole("USER");
        return secrepo.save(userdao);
    }

    public String testLoadUser(String username) {
    user_dao user = secrepo.findByUsername(username);
    if (user == null) {
        System.out.println("User not found for username: " + username);
    } else {
       return user.getUsername() + ", " + user.getRole();
    }
    return username + " not found";
    
}


    public String login(user_dao userdao) {

        user_dao user = secrepo.findByUsername(userdao.getUsername());
        System.out.println(user.getRole());
        try{
        Authentication auth = authmanager.authenticate(
            new UsernamePasswordAuthenticationToken(userdao.getUsername(), userdao.getPassword())
        );

        if (auth.isAuthenticated()) {
            return jwt.generateToken(user);
        } else {
            return "Login failed";
        }
    }
    catch(Exception e){
        return e.getMessage();
    }

  
    
}

}