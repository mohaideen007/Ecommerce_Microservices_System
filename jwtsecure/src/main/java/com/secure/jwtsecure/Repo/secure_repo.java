package com.secure.jwtsecure.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secure.jwtsecure.Model.user_dao;

public interface secure_repo extends JpaRepository<user_dao, Long> {

    user_dao findByUsername(String username);

}
