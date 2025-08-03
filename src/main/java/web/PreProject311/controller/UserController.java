package web.PreProject311.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.PreProject311.model.User;
import web.PreProject311.service.UserService;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    public String userPage(Principal principal, Model model) {
        String username = principal.getName();
        User current = (User) userService.loadUserByUsername(username);
        model.addAttribute("user", current);
        return "user";
    }
}
