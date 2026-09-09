package com.liubimba.backend.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Collection;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class RoleDTO {
    String name;
    Collection<PrivilegeDTO> privileges;
}
