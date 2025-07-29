package web.PreProject311.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.PreProject311.model.User;
import web.PreProject311.service.RoleService;
import web.PreProject311.service.UserService;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        User current = (User) userService.loadUserByUsername(username);

        model.addAttribute("user", current);
        model.addAttribute("users", userService.index());
        model.addAttribute("newUser", new User());
        model.addAttribute("allRoles", roleService.findAll());
        return "admin";
    }

    @GetMapping("/adminUser")
    public String userAdminPage(Principal principal, Model model) {
        String username = principal.getName();
        User current = (User) userService.loadUserByUsername(username);
        model.addAttribute("currentUser", current);
        model.addAttribute("users", userService.index());
        model.addAttribute("allRoles", roleService.findAll());
        return "adminUser";
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.findAll());
        return "new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/users/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.show(id));
        model.addAttribute("allRoles", roleService.findAll());
        return "edit";
    }

    @PatchMapping("/users/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute User user) {
        userService.update(id, user);
        return "redirect:/admin";
    }


    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }

}
