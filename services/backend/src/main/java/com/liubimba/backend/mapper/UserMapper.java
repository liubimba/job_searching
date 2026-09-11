package com.liubimba.backend.mapper;

import com.liubimba.backend.dto.UserDTO;
import com.liubimba.backend.entity.PrivilegeEntity;
import com.liubimba.backend.entity.RoleEntity;
import com.liubimba.backend.entity.UserEntity;
import com.liubimba.backend.entity.UserKey;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper {
     UserEntity toEntity(UserDTO dto) ;
     UserDTO toDto(UserEntity entity);
}
