package com.kovalchuk.management_system.service;

import com.kovalchuk.management_system.dal.model.Role;


import java.util.List;

/**
 * Service class for {@link Role}.
 *
 * @author Aleskey Kovalchuk
 */

public interface RoleService {

    List<Role> findAll();
}
