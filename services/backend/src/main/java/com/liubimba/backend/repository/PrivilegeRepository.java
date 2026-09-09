package com.liubimba.backend.repository;

import com.liubimba.backend.entity.PrivilegeEntity;
import com.liubimba.backend.enums.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<PrivilegeEntity, Long> {
    PrivilegeEntity findByName(String name);

    boolean existsByKey(Privilege key);
}
