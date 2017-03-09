package com.onlinebanking.userportal.service.serviceImpl;

import com.onlinebanking.userportal.dao.RoleDao;
import com.onlinebanking.userportal.domain.security.Role;
import com.onlinebanking.userportal.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public Role findByName(String name) {
        return roleDao.findByName(name);
    }
}
