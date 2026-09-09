package com.liubimba.backend.repository;

import com.liubimba.backend.entity.RoleEntity;
import com.liubimba.backend.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(String name);

    boolean existsByKey(Role key);
}
