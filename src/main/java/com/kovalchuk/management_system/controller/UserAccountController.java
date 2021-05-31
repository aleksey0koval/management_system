package com.kovalchuk.management_system.controller;

import com.kovalchuk.management_system.dal.model.UserAccount;
import com.kovalchuk.management_system.service.RoleService;
import com.kovalchuk.management_system.service.UserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String showAllUserAccounts(Model model) {
        model.addAttribute("users", userAccountService.findAll());
        return "list-users";
    }

    @GetMapping("/{id}")
    public String getByUserId(@PathVariable Long id,
                              Model model) {
        model.addAttribute("user", userAccountService.findById(id));
        return "view-user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new UserAccount());
        model.addAttribute("role", roleService.findAll());
        return "new-user";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable Long id,
                           Model model) {
        model.addAttribute("user", userAccountService.findById(id));
        model.addAttribute("role", roleService.findAll());
        return "edit-user";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user") UserAccount userAccount,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "new-user";
        }
        userAccountService.save(userAccount);
        return "redirect:";
    }

    @PostMapping("{id}/updateUser")
    public String updateUser(@ModelAttribute("user") UserAccount userAccount,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "edit-user";
        }

        userAccountService.save(userAccount);
        return "redirect:" + userAccount.getId();

    }


}
