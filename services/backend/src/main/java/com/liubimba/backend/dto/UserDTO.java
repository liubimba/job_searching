package com.liubimba.backend.dto;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class UserDTO {
    String email;
    String password;

    String firstName;
    String lastName;

    Boolean isEmailVerified;
}
