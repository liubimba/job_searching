package com.liubimba.backend.dto;

import com.liubimba.backend.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Collection;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class RoleDTO {
    @Enumerated(EnumType.STRING)
    Role role;
    String description;
    Collection<PrivilegeDTO> privileges;
}
