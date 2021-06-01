package com.kovalchuk.management_system.service.impl;

import com.kovalchuk.management_system.dal.model.UserAccount;
import com.kovalchuk.management_system.dal.repository.UserAccountRepository;
import com.kovalchuk.management_system.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Implementation of {@link UserAccountService} interface.
 *
 * @author Aleskey Kovalchuk
 */

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
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

//
//    @Override
//    public void saveDto(UserRoleDto userRoleDTO) {
//        UserAccount userAccount = null;
//        if (userRoleDTO.getId() == null) {
//            userAccount = new UserAccount();
//            userAccount.setUsername(userRoleDTO.getUsername());
//            userAccount.setPassword(bCryptPasswordEncoder.encode(userRoleDTO.getPassword()));
//            userAccount.setFirstName(userRoleDTO.getFirstName());
//            userAccount.setLastName(userRoleDTO.getLastName());
//            userAccount.setDate(Date.valueOf(LocalDate.now()));
//        } else {
//            userAccount = userAccountRepository.findById(userRoleDTO.getId()).get();
////            if (userRoleDTO.getEnabled().equals("ACTIVE")) {
////                userAccount.setEnabled(true);
////            } else {
////                userAccount.setEnabled(false);
////            }
//        }
//
//        userAccountRepository.save(userAccount);
//    }

//    @Override
//    public UserRoleDto getDto(Long id) {
//        UserAccount userAccount = userAccountRepository.findById(id).get();
//        UserRoleDto dto = new UserRoleDto();
//        dto.setId(userAccount.getId());
//        dto.setUsername(userAccount.getUsername());
//        dto.setPassword(userAccount.getPassword());
//        dto.setFirstName(userAccount.getFirstName());
//        dto.setLastName(userAccount.getLastName());
//        dto.setDate(userAccount.getDate());
////        if (userAccount.isEnabled()) {
////            dto.setEnabled("ACTIVE");
////        } else {
////            dto.setEnabled("INACTIVE");
////        }
//        return dto;
//
////        public List<UserRoleDto> listDto() {
////            return (UserRoleDto) userAccountRepository.getAllDto();
////        }
//    }
//
//    public UserRoleDto getUserByUsername(String username){
//        return userConverter.toDto(userAccountRepository.findByUsername(username));
//    }
}

