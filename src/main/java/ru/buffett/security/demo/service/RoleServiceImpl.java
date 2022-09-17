package ru.buffett.security.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.buffett.security.demo.model.Role;
import ru.buffett.security.demo.repository.RoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Set<Role> getAllRoles() {
        return new HashSet<>(roleRepository.findAll());
    }

    @Override
    public Set<Role> findRoleById(List<Long> rolesId) {
        return new HashSet<>(roleRepository.findAllById(rolesId));
    }

    @Override
    public Set<Role> findRoleByName(String roleName) {
        Set<Role> roles = new HashSet<>();
        for (Role role : getAllRoles()) {
            if (roleName.contains(role.getName())) {
                roles.add(role);
            }
        }
        return roles;
    }
}
