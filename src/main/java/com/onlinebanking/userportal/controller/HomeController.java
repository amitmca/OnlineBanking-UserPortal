package com.onlinebanking.userportal.controller;

import com.onlinebanking.userportal.domain.PrimaryAccount;
import com.onlinebanking.userportal.domain.SavingsAccount;
import com.onlinebanking.userportal.domain.User;
import com.onlinebanking.userportal.domain.security.UserRole;
import com.onlinebanking.userportal.service.RoleService;
import com.onlinebanking.userportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @RequestMapping("/")
    public String home() {

        return "redirect:/index";
    }


    @RequestMapping("/index")
    public String index() {

        return "index";
    }


    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "signup";
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("user") User user, Model model) {

        if (userService.userExists(user.getUsername(), user.getEmail())) {

            if (userService.emailExists(user.getEmail())) {
                model.addAttribute("emailExists", true);
            }
            if (userService.usernameExists(user.getUsername())) {
                model.addAttribute("usernameExists", true);
            }

            return "signup";

        } else {

            Set<UserRole> userRoles = new HashSet<>();
            userRoles.add(new UserRole(user, roleService.findByName("ROLE_USER")));

            userService.createUser(user, userRoles);

            return "redirect:/";
        }
    }


    @RequestMapping("/userPortal")
    public String userPortal(Principal principal, Model model) {

        User user = userService.findByUsername(principal.getName());

        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        SavingsAccount savingsAccount = user.getSavingsAccount();

        model.addAttribute("primaryAccount", primaryAccount);
        model.addAttribute("savingsAccount", savingsAccount);

        return "userPortal";
    }
}
