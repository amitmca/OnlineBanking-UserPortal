package com.onlinebanking.userportal.dao;

import com.onlinebanking.userportal.domain.User;
import org.springframework.data.repository.CrudRepository;


public interface UserDao extends CrudRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);
}
