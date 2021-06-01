package com.kovalchuk.management_system.service.security;

import com.kovalchuk.management_system.dal.model.UserAccount;
import com.kovalchuk.management_system.dal.repository.UserAccountRepository;
import com.kovalchuk.management_system.service.dto.UserRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.getUserAccountByUsername(username);
        if (userAccount == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserAccountDetails(userAccount);
    }
}
