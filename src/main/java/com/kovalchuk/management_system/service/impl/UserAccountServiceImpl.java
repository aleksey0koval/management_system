package com.kovalchuk.management_system.service.impl;

import com.kovalchuk.management_system.dal.model.UserAccount;
import com.kovalchuk.management_system.dal.repository.RoleRepository;
import com.kovalchuk.management_system.dal.repository.UserAccountRepository;
import com.kovalchuk.management_system.service.UserAccountService;
import com.kovalchuk.management_system.service.dto.UserRoleDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Implementation of {@link UserAccountService} interface.
 *
 * @author Aleskey Kovalchuk
 * @version 1.0
 */

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private UserAccountRepository userAccountRepository;
    private RoleRepository roleRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository,
                                  RoleRepository roleRepository) {
        this.userAccountRepository = userAccountRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public List<UserAccount> findAll() {
        return userAccountRepository.findAll();
    }



    @Override
    public UserAccount findById(Long id) {
        return userAccountRepository.findById(id).get();
    }

    @Override
    public UserAccount findByUsername(String username) {
        return userAccountRepository.findByUsername(username);
    }

    @Override
    public void save(UserAccount userAccount) {
        if (userAccount.getId() == null) {
            userAccount.setDate(Date.valueOf(LocalDate.now()));
        }

        userAccountRepository.save(userAccount);
    }




    @Override
    public void saveDto(UserRoleDTO userRoleDTO) {
        UserAccount userAccount = null;
        if (userRoleDTO.getId() == null) {
            userAccount = new UserAccount();
            userAccount.setUsername(userRoleDTO.getUsername());
            userAccount.setPassword(userRoleDTO.getPassword());
            userAccount.setFirstName(userRoleDTO.getFirstName());
            userAccount.setLastName(userRoleDTO.getLastName());
            userAccount.setDate(Date.valueOf(LocalDate.now()));
        } else {
            userAccount = userAccountRepository.findById(userRoleDTO.getId()).get();
            if (userRoleDTO.getEnabled().equals("ACTIVE")) {
                userAccount.setEnabled(true);
            } else {
                userAccount.setEnabled(false);
            }
//            userAccount.;
        }

        userAccountRepository.save(userAccount);
    }

    @Override
    public UserRoleDTO getDto(UserAccount userAccount) {
        UserRoleDTO dto = new UserRoleDTO();
        dto.setId(userAccount.getId());
        dto.setPassword(userAccount.getPassword());
        dto.setFirstName(userAccount.getFirstName());
        dto.setLastName(userAccount.getLastName());
        dto.setDate(userAccount.getDate());
        if (userAccount.isEnabled()) {
            dto.setEnabled("ACTIVE");
        } else {
            dto.setEnabled("INACTIVE");
        }
//        dto.setRole();
        return dto;
    }
}

