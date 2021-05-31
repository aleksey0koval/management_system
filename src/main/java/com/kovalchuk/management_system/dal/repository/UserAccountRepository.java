package com.kovalchuk.management_system.dal.repository;

import com.kovalchuk.management_system.dal.model.UserAccount;
import com.kovalchuk.management_system.service.dto.UserRoleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByUsername(String username);
}
