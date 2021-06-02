package com.kovalchuk.management_system.controller;

import com.kovalchuk.management_system.dal.repository.UserAccountRepository;
import com.kovalchuk.management_system.service.UserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserAccountSearchController {
    private UserAccountService userAccountService;

    public UserAccountSearchController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }


    @GetMapping("/search")
    public String searchUserAccount(@RequestParam(value = "param", required = false) String param,
                                    Model model) {
        if (param != null && !"".equals(param.trim())) {
            model.addAttribute("users", userAccountService.searchUserAccount(param));
            return "search-user";
        }
        return "search-user";
    }
}
