package com.kovalchuk.management_system.service.impl;

import com.kovalchuk.management_system.dal.model.Role;
import com.kovalchuk.management_system.dal.model.UserAccount;
import com.kovalchuk.management_system.dal.repository.RoleRepository;
import com.kovalchuk.management_system.dal.repository.UserAccountRepository;
import com.kovalchuk.management_system.service.UserAccountService;
import com.kovalchuk.management_system.service.dto.RequestDto;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation of {@link UserAccountService} interface.
 *
 * @author Aleskey Kovalchuk
 */

@Service
public class UserAccountServiceImpl implements UserAccountService {
    private UserAccountRepository userAccountRepository;
    private RoleRepository roleRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository, RoleRepository roleRepository) {
        this.userAccountRepository = userAccountRepository;
        this.roleRepository = roleRepository;
    }

    @Bean
    private BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public Page<UserAccount> findAll(Pageable pageable) {
        return userAccountRepository.findAll(pageable);
    }

    @Override
    public List<UserAccount> findAll() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccount findById(Long id) {
        return userAccountRepository.findById(id).get();
    }

    @Override
    public UserAccount findByUsername(String username) {
        return userAccountRepository.findByUsername(username);
    }

    @Override
    public void save(RequestDto requestDto) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(requestDto.getUsername());
        userAccount.setFirstName(requestDto.getFirstName());
        userAccount.setLastName(requestDto.getLastName());
        userAccount.setPassword(bCryptPasswordEncoder().encode(requestDto.getPassword()));
        userAccount.setDate(Date.valueOf(LocalDate.now()));
        userAccount.setEnabled(requestDto.isEnabled());

        Role role = roleRepository.findByName(requestDto.getRole());
        role.setName(requestDto.getRole());
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        userAccount.setRoles(roles);

        userAccountRepository.save(userAccount);
    }

    @Override
    public void update(RequestDto requestDto) {
        UserAccount userAccount = userAccountRepository.findById(requestDto.getId()).get();

        String password = requestDto.getPassword();
        if(!userAccount.getPassword().equals(password)){
           password = bCryptPasswordEncoder().encode(password);
        }
        userAccount.setUsername(requestDto.getUsername());
        userAccount.setPassword(password);
        userAccount.setFirstName(requestDto.getFirstName());
        userAccount.setLastName(requestDto.getLastName());
        userAccount.setDate(requestDto.getDate());
        userAccount.setEnabled(requestDto.isEnabled());

        Role role = roleRepository.findByName(requestDto.getRole());
        role.setName(requestDto.getRole());
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        userAccount.setRoles(roles);

        userAccountRepository.save(userAccount);
    }

    @Override
    public RequestDto getRequestDto(Long id) {
        RequestDto requestDto = new RequestDto();
        UserAccount userAccount = userAccountRepository.findById(id).get();
        requestDto.setId(userAccount.getId());
        requestDto.setUsername(userAccount.getUsername());
        requestDto.setPassword(userAccount.getPassword());
        requestDto.setFirstName(userAccount.getFirstName());
        requestDto.setLastName(userAccount.getLastName());
        requestDto.setDate(userAccount.getDate());
        requestDto.setEnabled(userAccount.isEnabled());
        requestDto.setRole(userAccount.getRoles().stream().findFirst().get().getName());
        return requestDto;
    }

    @Override
    public List<UserAccount> searchUserAccount(String param) {
        return userAccountRepository.findAll()
                .stream()
                .filter(userAccount -> List.of(
                        userAccount.getUsername()
                        ).stream().
                                anyMatch(s -> s.toLowerCase().contains(param.toLowerCase()))
                )
                .collect(Collectors.toList());
    }

    @Override
    public Page<UserAccount> findPaginated(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return userAccountRepository.findAll(pageable);
    }
}

