package com.kovalchuk.management_system.service.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@Data
public class UserRoleDTO {

    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String role;

    private Date date;

    private String enabled;
}
