package com.kovalchuk.management_system.dal.repository;

import com.kovalchuk.management_system.dal.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
