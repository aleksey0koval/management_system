package com.kovalchuk.management_system.service.dto;

import com.kovalchuk.management_system.dal.model.Role;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Set;

@Component
@Data
public class UserRoleDto {

    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String role;

    private Date date;

    private boolean enabled;

    Set<Role> roles;
}
