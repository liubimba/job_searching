package com.liubimba.backend.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignUpDTO {
    @NotNull(message = "email can't be null")
    @NotBlank(message = "email can't be blank")
    String email;
    @NotNull(message = "password can't be null")
    @NotBlank(message = "password can't be blank")
    String password;
    @NotNull
    @NotBlank
    RoleDTO role;
}
