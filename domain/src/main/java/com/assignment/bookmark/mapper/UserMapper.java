package com.assignment.bookmark.mapper;

import com.assignment.entity.UserEntity;
import com.assignment.model.UserDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract List<UserEntity> mapUserDetailsList(List<UserDto> UserDtoList);

    public abstract UserEntity mapOneUserDetail(UserDto UserDto);

    @InheritInverseConfiguration(name = "mapUserDetailsList")
    public abstract List<UserDto> mapUserDetailsDtoList(List<UserEntity> cardDetailsEntities);

    @InheritInverseConfiguration(name = "mapOneUserDetail")
    public abstract UserDto mapUserDetailDto(UserEntity UserEntity);
}
