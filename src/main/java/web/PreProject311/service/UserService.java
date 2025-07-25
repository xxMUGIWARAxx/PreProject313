package web.PreProject311.service;


import web.PreProject311.model.User;

import java.util.List;

public interface UserService {
    List<User> index();

    User show(Long id);

    void save(User user);

    void update(Long id, User updatedUser);

    void delete(Long id);

    Object loadUserByUsername(String username);
}
