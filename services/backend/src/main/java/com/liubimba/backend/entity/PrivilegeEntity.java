package com.liubimba.backend.entity;

import com.liubimba.backend.enums.Privilege;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "privileges")
public class PrivilegeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private Privilege key;

    @Column(nullable = false)
    private String description;
    @ManyToMany(mappedBy = "privileges")
    private Collection<RoleEntity> roles;
}
