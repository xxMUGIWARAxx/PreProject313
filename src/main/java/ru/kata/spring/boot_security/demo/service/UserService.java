package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findUserByUsername(String username);

    List<User> getAllUsers();

    User findUserById(Long id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);


}
