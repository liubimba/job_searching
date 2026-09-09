package com.liubimba.backend.bootstrap;

import com.liubimba.backend.entity.PrivilegeEntity;
import com.liubimba.backend.entity.RoleEntity;
import com.liubimba.backend.enums.Privilege;
import com.liubimba.backend.enums.Role;
import com.liubimba.backend.repository.PrivilegeRepository;
import com.liubimba.backend.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SetupDataListener implements ApplicationListener<ContextRefreshedEvent> {
    RoleRepository roleRepository;
    PrivilegeRepository privilegeRepository;

    @Autowired
    public SetupDataListener(RoleRepository roleRepository, PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadDB();
    }

    private void loadDB() {
        loadPrivileges();
        loadRoles();
    }

    private void loadPrivileges() {
        Collection<PrivilegeInit> privileges = List.of(
                new PrivilegeInit(Privilege.READ, "Read privilege"),
                new PrivilegeInit(Privilege.WRITE, "Write privilege")
        );

        if (privileges.size() != Privilege.values().length) {
            throw new RuntimeException("Specify all existing privileges types!");
        }

        privileges.forEach(init -> {
            if (privilegeRepository.existsByKey(init.privilege)) {
                return;
            }
            PrivilegeEntity entity = new PrivilegeEntity();
            entity.setKey(init.privilege);
            entity.setDescription(init.description);
            privilegeRepository.save(entity);
        });
    }

    private void loadRoles() {
        Collection<RoleInit> roles = List.of(
                new RoleInit(Role.ADMIN, "Admin", List.of()),
                new RoleInit(Role.APPLICANT, "Applicant", List.of()),
                new RoleInit(Role.RECRUITER, "Recruiter", List.of())
        );

        if (roles.size() != Role.values().length) {
            throw new RuntimeException("");
        }

        roles.forEach(init -> {
            if (roleRepository.existsByKey(init.role)) {
                return;
            }

            RoleEntity entity = new RoleEntity();
            entity.setDescription(init.description);
            entity.setKey(init.role);

            roleRepository.save(entity);
        });
    }

    private record PrivilegeInit(
            Privilege privilege,
            String description
    ) {
    }

    private record RoleInit(
            Role role,
            String description,
            Collection<String> privileges
    ) {
    }
}
