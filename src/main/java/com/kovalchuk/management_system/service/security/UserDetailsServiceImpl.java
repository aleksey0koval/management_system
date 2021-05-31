package com.kovalchuk.management_system.service.security;

import com.kovalchuk.management_system.service.UserAccountService;
import com.kovalchuk.management_system.service.dto.UserRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRoleDto userRoleDto = userAccountService.getUserByUsername(username);
        if (userRoleDto == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserAccountDetails(userRoleDto);
    }
}
