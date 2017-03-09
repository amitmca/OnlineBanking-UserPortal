package com.onlinebanking.userportal.service;


import com.onlinebanking.userportal.domain.User;
import com.onlinebanking.userportal.domain.security.UserRole;

import java.util.Set;


public interface UserService {

    User findByUsername(String username);
    User findByEmail(String email);

    boolean userExists(String username, String email);
    boolean usernameExists(String username);
    boolean emailExists(String email);

    void save(User user);

    User createUser(User user, Set<UserRole> userRoles);
}
