package com.kovalchuk.management_system.dal.repository;

import com.kovalchuk.management_system.dal.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByUsername(String username);
}
