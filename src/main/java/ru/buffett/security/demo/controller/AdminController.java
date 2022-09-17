package ru.buffett.security.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.buffett.security.demo.service.UserService;
import ru.buffett.security.demo.model.User;
import ru.buffett.security.demo.service.RoleService;

import java.security.Principal;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("")
    public String getAllUsers(Model model, Principal admin) {
        model.addAttribute("admin", userService.findUserByUsername(admin.getName()));
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", roleService.getAllRoles());
        return "index";
    }

    @GetMapping("create-user")
    public String getCreateUserForm(Model model, Principal admin) {
        model.addAttribute("admin", userService.findUserByUsername(admin.getName()));
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("edit-user/{id}")
    public String getEditUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("updateUser", userService.findUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") Long id,
                           @RequestParam("role") String role) {
        user.setRoles(roleService.findRoleByName(role));
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
