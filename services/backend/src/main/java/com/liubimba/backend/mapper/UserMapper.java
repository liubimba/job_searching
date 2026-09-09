package com.liubimba.backend.mapper;

import com.liubimba.backend.dto.UserDTO;
import com.liubimba.backend.entity.PrivilegeEntity;
import com.liubimba.backend.entity.RoleEntity;
import com.liubimba.backend.entity.UserEntity;
import com.liubimba.backend.entity.UserKey;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toEntity(UserDTO dto) {
        RoleEntity role = new RoleEntity();
        role.setName(dto.getRole().getName());
        role.setPrivileges(dto.getRole().getPrivileges().stream().map(privilegeDTO -> {
            PrivilegeEntity privilege = new PrivilegeEntity();
            privilege.setName(privilegeDTO.getName());
            return privilege;
        }).toList());

        UserKey key = new UserKey();
        key.setEmail(dto.getEmail());
        key.setRole(role);

        UserEntity entity = new UserEntity();
        entity.setPassword(dto.getPassword());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setKey(key);

        return entity;
    }
}
