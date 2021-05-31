package com.kovalchuk.management_system.service;


import com.kovalchuk.management_system.dal.model.UserAccount;
import com.kovalchuk.management_system.service.dto.UserRoleDTO;

import java.util.List;

/**
 * Service class for {@link UserAccount}.
 *
 * @author Aleskey Kovalchuk
 * @version 1.0
 */


public interface UserAccountService {

    List<UserAccount> findAll();

    UserAccount findById(Long id);

    UserAccount findByUsername(String username);

    void save(UserAccount userAccount);

    UserRoleDTO getDto(UserAccount userAccount);

    void saveDto(UserRoleDTO userRoleDTO);

}
