package web.PreProject311.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import web.PreProject311.model.Role;
import web.PreProject311.repositories.RoleRepository;

@Component
public class RoleConverter implements Converter<String, Role> {

    private final RoleRepository roleRepo;

    public RoleConverter(RoleRepository roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role convert(String source) {
        Long id = Long.parseLong(source);
        return roleRepo.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Unknown Role ID: " + source));
    }
}