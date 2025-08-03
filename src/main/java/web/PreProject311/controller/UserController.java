package web.PreProject311.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.PreProject311.model.User;
import web.PreProject311.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile(Principal principal) {
        String username = principal.getName();
        User current = (User) userService.loadUserByUsername(username);
        return ResponseEntity.ok(current);
    }
}
