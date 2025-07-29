package web.PreProject311.service;

import web.PreProject311.model.Role;
import java.util.List;
import java.util.Set;


public interface RoleService {
    List<Role> findAll();
    Role save(Role role);
    Set<Role> findByIds(Set<Long> ids);
}