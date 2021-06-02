package com.kovalchuk.management_system.service;


import com.kovalchuk.management_system.dal.model.UserAccount;
import com.kovalchuk.management_system.service.dto.RequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Service class for {@link UserAccount}.
 *
 * @author Aleskey Kovalchuk
 */

public interface UserAccountService {
    Page<UserAccount> findAll(Pageable pageable);

    List<UserAccount> findAll();

    UserAccount findById(Long id);

    UserAccount findByUsername(String username);

    void save(RequestDto requestDto);

    void update(RequestDto requestDto);

    RequestDto getRequestDto(Long id);

    List<UserAccount> searchUserAccount(String param);
}
