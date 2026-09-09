package com.liubimba.backend.dto;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PROTECTED)
@Data
public class UserDTO {
    String email;
    String password;

    String firstName;
    String lastName;

    RoleDTO role;

    Boolean isEmailVerified;
}
