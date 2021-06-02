package com.kovalchuk.management_system.dal.repository;

import com.kovalchuk.management_system.dal.model.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    Page<UserAccount> findAll(Pageable pageable);

    UserAccount findByUsername(String username);

    @Query("SELECT u FROM UserAccount u WHERE u.username = :username")
    UserAccount getUserAccountByUsername(@Param("username")String username);
}
