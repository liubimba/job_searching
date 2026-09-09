package com.liubimba.backend.entity;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Embeddable
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserKey {
    String email;
    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    RoleEntity role;
}
