package ru.buffett.security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.buffett.security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findUserByUsername(String username);

    List<User> getAllUsers();

    User findUserById(Long id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);


}
