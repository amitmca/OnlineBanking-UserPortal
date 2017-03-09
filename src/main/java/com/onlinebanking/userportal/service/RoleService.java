package com.onlinebanking.userportal.service;

import com.onlinebanking.userportal.domain.security.Role;


public interface RoleService {

    Role findByName(String name);
}
