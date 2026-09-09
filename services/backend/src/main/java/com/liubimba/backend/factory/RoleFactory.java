package com.liubimba.backend.factory;

import com.liubimba.backend.dto.RoleDTO;
import com.liubimba.backend.entity.RoleEntity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleFactory {
    PrivilegeFactory privilegeFactory;

    @Autowired
    public RoleFactory(PrivilegeFactory privilegeFactory) {
        this.privilegeFactory = privilegeFactory;
    }


    public class ApplicantBuilder {

        public RoleDTO dto() {

        }

        public RoleEntity entity() {

        }
    }

    public ApplicantBuilder applicant() {

    }
}
