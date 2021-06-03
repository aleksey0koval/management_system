package com.kovalchuk.management_system.controller;

import com.kovalchuk.management_system.dal.model.UserAccount;
import com.kovalchuk.management_system.controller.exception_handling.DuplicateUsernameException;
import com.kovalchuk.management_system.controller.exception_handling.UsernameDuplicate;
import com.kovalchuk.management_system.service.RoleService;
import com.kovalchuk.management_system.service.UserAccountService;
import com.kovalchuk.management_system.service.dto.RequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserAccountController {

    private UserAccountService userAccountService;
    private RoleService roleService;

    public UserAccountController(UserAccountService userAccountService, RoleService roleService) {
        this.userAccountService = userAccountService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String showAllUserAccounts(Model model,
                                      HttpServletRequest request) {
        int page = 0;
        int size = 4;

        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }
        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }
        model.addAttribute("users", userAccountService.findAll(PageRequest.of(page, size)));
        return "list-users";
    }

    @GetMapping("/{id}")
    public String getByUserId(@PathVariable Long id,
                              Model model) {
        model.addAttribute("user", userAccountService.findById(id));
        return "view-user";
    }

    @GetMapping("/new")
    public String newUser(Model model, Model model1) {
        model.addAttribute("user", new RequestDto());
        model1.addAttribute("role", roleService.findAll());
        return "new-user";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable Long id,
                           Model model) {
        model.addAttribute("user", userAccountService.getRequestDto(id));
        model.addAttribute("role", roleService.findAll());
        return "edit-user";
    }

    @PostMapping("/createUser")
    public String createUser(@Valid @ModelAttribute("user") RequestDto requestDto,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "new-user";
        }
        UserAccount username = userAccountService.findByUsername(requestDto.getUsername());
        if (username != null) {
            throw new DuplicateUsernameException("Такое имя пользователя существует " +
                    username + ", придумайте другое имя username!!!");
        }
        userAccountService.save(requestDto);
        return "redirect:";
    }

    @PostMapping("{id}/updateUser")
    public String updateUser(@Valid @ModelAttribute("user") RequestDto requestDto,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "edit-user";
        }
        userAccountService.update(requestDto);
        return "redirect:";
    }

    @ExceptionHandler
    public String handleException(DuplicateUsernameException exception
                                  ) {
        UsernameDuplicate duplicate = new UsernameDuplicate();
        duplicate.setInfo(exception.getMessage());
        return "error";
    }


}
