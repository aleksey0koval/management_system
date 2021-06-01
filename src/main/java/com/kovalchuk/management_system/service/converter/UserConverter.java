//package com.kovalchuk.management_system.service.converter;
//
//import com.kovalchuk.management_system.dal.model.Role;
//import com.kovalchuk.management_system.dal.model.UserAccount;
//import com.kovalchuk.management_system.service.dto.UserRoleDto;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.Set;
//
//@Data
//@Component
//public class UserConverter {

//    public UserAccount fromDTO(UserRoleDto userRoleDto) {
//        UserAccount userAccount = new UserAccount();
//        userAccount.setId(userRoleDto.getId());
//        userAccount.setUsername(userRoleDto.getUsername());
//        userAccount.setPassword(userRoleDto.getPassword());
////        userAccount.setRole(userRoleDto.getRole());
//        userAccount.setEnabled(userRoleDto.isEnabled());
//        return userAccount;
//    }

//    public UserRoleDto toDto(UserAccount userAccount) {
//        UserRoleDto userRoleDto = new UserRoleDto();
//        userRoleDto.setId(userAccount.getId());
//        userRoleDto.setUsername(userAccount.getUsername());
//        System.out.println(userAccount.getUsername());
//        userRoleDto.setPassword(userAccount.getPassword());
//        System.out.println(userAccount.getPassword());
//        Set<Role> roles = userAccount.getRoles();
//        System.out.println(roles.stream().findFirst().get().getName());
////        userRoleDto.setRole(roles.stream().findFirst().get().getName());
//        userRoleDto.setRoles(userAccount.getRoles());
////        userRoleDto.setRole();
//        userRoleDto.setEnabled(userAccount.isEnabled());
//        return userRoleDto;
//    }

//}
