package web.PreProject311.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.PreProject311.model.User;
import web.PreProject311.repositories.RoleRepository;
import web.PreProject311.service.UserService;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleRepository roleRepository;

    @Autowired
    public AdminController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping()
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        User current = (User) userService.loadUserByUsername(username);
        model.addAttribute("user", current);
        return "admin";
    }

    @GetMapping("/users")
    public String allUsers(ModelMap model) {
        model.addAttribute("messages", userService.index());
        return "users";
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleRepository.findAll());
        return "new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.show(id));
        model.addAttribute("allRoles", roleRepository.findAll());
        return "edit";
    }

    @PatchMapping("/users/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute User user) {
        userService.update(id, user);
        return "redirect:/admin/users";
    }


    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }

}
