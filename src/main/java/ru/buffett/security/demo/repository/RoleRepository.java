package ru.buffett.security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.buffett.security.demo.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
