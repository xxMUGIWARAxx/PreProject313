package ru.buffett.security.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.buffett.security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public String getUserPage(Model model, Principal user) {
        model.addAttribute("user", userService.findUserByUsername(user.getName()));
        return "user";
    }
}
