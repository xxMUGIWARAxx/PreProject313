package web.PreProject311.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.PreProject311.model.Role;
import web.PreProject311.model.User;
import web.PreProject311.repositories.RoleRepository;
import web.PreProject311.service.UserService;

import java.util.Set;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner initData(UserService userService, RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.count() == 0) {
                roleRepository.save(new Role("ROLE_USER"));
                roleRepository.save(new Role("ROLE_ADMIN"));
            }
            if (userService.index().isEmpty()) {
                Role userRole = roleRepository.findByRole("ROLE_USER").orElseThrow();
                Role adminRole = roleRepository.findByRole("ROLE_ADMIN").orElseThrow();

                User user = new User("user", "user@mail.ru", "user");
                user.setRoles(Set.of(userRole));
                userService.save(user);

                User admin = new User("admin", "admin@mail.ru", "admin");
                admin.setRoles(Set.of(adminRole));
                userService.save(admin);
            }
        };
    }
}
