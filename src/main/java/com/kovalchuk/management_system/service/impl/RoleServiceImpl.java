package com.kovalchuk.management_system.service.impl;

import com.kovalchuk.management_system.dal.model.Role;
import com.kovalchuk.management_system.dal.repository.RoleRepository;
import com.kovalchuk.management_system.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link RoleService} interface.
 *
 * @author Aleskey Kovalchuk
 */

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
