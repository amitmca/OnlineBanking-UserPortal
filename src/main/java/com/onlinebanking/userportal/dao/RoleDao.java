package com.onlinebanking.userportal.dao;

import com.onlinebanking.userportal.domain.security.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleDao extends CrudRepository<Role, Long> {

    Role findByName(String name);
}
