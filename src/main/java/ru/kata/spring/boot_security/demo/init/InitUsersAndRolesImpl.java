package ru.kata.spring.boot_security.demo.init;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class InitUsersAndRolesImpl implements InitUsersAndRoles {

    private final UserService userService;
    private final RoleRepository roleRepository;

    @Override
    @PostConstruct
    public void addStartRoles() {
        roleRepository.save(new Role(1L, "ROLE_ADMIN"));
        roleRepository.save(new Role(2L, "ROLE_USER"));
    }

    @Override
    @PostConstruct
    public void addStartUsers() {
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(roleRepository.findById(1L).orElse(null));

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleRepository.findById(2L).orElse(null));

        User admin = new User(1L, "admin", "adminov", "admin", (byte) 33, "admin@gmail.com", "admin", adminRoles);
        User user = new User(2L, "user", "userov", "user", (byte) 22, "user@gmail.com", "user", userRoles);
        userService.addUser(admin);
        userService.addUser(user);

        System.out.println("\n\n username - admin : password - admin\n");
        System.out.println("\n username - user : password - user\n");
    }
}