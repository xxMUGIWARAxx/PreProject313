package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    Set<Role> getAllRoles();

    Set<Role> findRoleById(List<Long> rolesId);

    Set<Role> findRoleByName(String roleName);

}
