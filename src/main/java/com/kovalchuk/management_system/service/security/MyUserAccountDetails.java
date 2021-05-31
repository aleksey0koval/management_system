package com.kovalchuk.management_system.service.security;

import com.kovalchuk.management_system.dal.model.Role;
import com.kovalchuk.management_system.dal.model.UserAccount;
import com.kovalchuk.management_system.service.dto.UserRoleDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MyUserAccountDetails implements UserDetails {

    private UserRoleDto userRoleDto;

    public MyUserAccountDetails(UserRoleDto userRoleDto) {
        this.userRoleDto = userRoleDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = userRoleDto.getRole();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();


        authorities.add(new SimpleGrantedAuthority(role));

        return authorities;
    }

    @Override
    public String getPassword() {
        return userRoleDto.getPassword();
    }

    @Override
    public String getUsername() {
        return userRoleDto.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
