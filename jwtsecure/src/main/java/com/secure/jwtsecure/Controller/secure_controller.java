package com.secure.jwtsecure.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secure.jwtsecure.Model.user_dao;
import com.secure.jwtsecure.Service.secure_service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/secure")
public class secure_controller {

    @Autowired
    private secure_service secser;

    @GetMapping("/verfied")
    public String getMethodName() {
        return secser.getMethodName();
    }

    @PostMapping("/add")
    public user_dao postMethodName(@RequestBody user_dao userdao ) {
        
        return secser.adduser(userdao);
    }
    

    @PostMapping("/login")
    public String login(@RequestBody user_dao user) {
        return secser.login(user);
    }


     @GetMapping("/user/{username}")
    public String testUser(@PathVariable String username) {
        return secser.testLoadUser(username);
        
    }

        // @PostMapping("/addrole")
        // public String addrole(@RequestBody user_dao userdao) {
        //     return secser.addrole(userdao);
        

        // }



}
