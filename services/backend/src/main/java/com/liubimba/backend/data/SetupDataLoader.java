package com.liubimba.backend.data;

import com.liubimba.backend.entity.PrivilegeEntity;
import com.liubimba.backend.entity.RoleEntity;
import com.liubimba.backend.repository.PrivilegeRepository;
import com.liubimba.backend.repository.RoleRepository;
import com.liubimba.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Objects;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean isSetup = false;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (isSetup) {
            return;
        }

        PrivilegeEntity readPrivilege = createPrivilegeIfNotFound("READ");
        PrivilegeEntity writePrivilege = createPrivilegeIfNotFound("WRITE");

    }

    PrivilegeEntity createPrivilegeIfNotFound(String name) {
        PrivilegeEntity privilege = privilegeRepository.findByName(name);
        if (Objects.isNull(privilege)) {
            privilege = new PrivilegeEntity();
            privilege.setName(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    RoleEntity createRoleIfNotFound(String name, Collection<PrivilegeEntity> privileges) {
        RoleEntity role = roleRepository.findByName(name);
        if (Objects.isNull(role)) {
            role = new RoleEntity();
            role.setName(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
