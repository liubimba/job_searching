package com.liubimba.backend.entity;

import com.liubimba.backend.enums.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "roles")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    Role key;

    @Column(nullable = false)
    String description;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id")
            ,
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"
            )
    )
    private Collection<PrivilegeEntity> privileges;
}
