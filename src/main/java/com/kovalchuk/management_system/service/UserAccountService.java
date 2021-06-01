package com.kovalchuk.management_system.service;


import com.kovalchuk.management_system.dal.model.UserAccount;
import com.kovalchuk.management_system.service.dto.UserRoleDto;

import java.util.List;

/**
 * Service class for {@link UserAccount}.
 *
 * @author Aleskey Kovalchuk
 */


public interface UserAccountService {

    List<UserAccount> findAll();

    UserAccount findById(Long id);

    UserAccount findByUsername(String username);

    void save(UserAccount userAccount);

//    UserRoleDto getDto(Long id);
//
//    void saveDto(UserRoleDto userRoleDTO);
//
//    UserRoleDto getUserByUsername(String username);

}
