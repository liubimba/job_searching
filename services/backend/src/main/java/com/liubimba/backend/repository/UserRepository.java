package com.liubimba.backend.repository;

import com.liubimba.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<T> findByEmail(String email);

    boolean existsByEmail(String email);
}
