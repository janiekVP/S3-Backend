package com.backend.ItemTracker.service;

import com.backend.ItemTracker.model.Role;
import com.backend.ItemTracker.model.User;
import com.backend.ItemTracker.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role Create(Role role) {
        Role savedRole = roleRepository.save(role);
        return savedRole;
    }

    public List<Role> GetAll() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }
}
