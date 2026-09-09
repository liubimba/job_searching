package com.liubimba.backend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(
        name = "users",
        uniqueConstraints = @UniqueConstraint(
                name = "uc_users_email_role",
                columnNames = {"email", "role"}
        )
)
@Entity
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;
    String firstName;
    String lastName;
    String password;

    @Embedded
    UserKey key;

    @Override
    @NullMarked
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    @NullMarked
    public String getUsername() {
        return key.getEmail();
    }
}
