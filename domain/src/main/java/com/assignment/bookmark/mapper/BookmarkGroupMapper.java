package com.assignment.bookmark.mapper;

import com.assignment.entity.BookmarkGroupEntity;
import com.assignment.entity.BookmarkGroupEntity;
import com.assignment.model.BookmarkGroupDto;
import com.assignment.model.BookmarkGroupDto;
import com.assignment.model.UserDto;
import com.google.gson.Gson;
import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public abstract class BookmarkGroupMapper {
    public abstract List<BookmarkGroupEntity> mapGroupDetailsList(List<BookmarkGroupDto> bookmarkGroupDtoList);

    public abstract BookmarkGroupEntity mapOneGroupDetail(BookmarkGroupDto BookmarkGroupDto);

    @InheritInverseConfiguration(name = "mapGroupDetailsList")
    public abstract List<BookmarkGroupDto> mapGroupDetailsDtoList(List<BookmarkGroupEntity> cardDetailsEntities);

    @InheritInverseConfiguration(name = "mapOneGroupDetail")
    public abstract BookmarkGroupDto mapGroupDetailDto(BookmarkGroupEntity BookmarkGroupEntity);

    @AfterMapping
    public void mapEntityExtraInformation(BookmarkGroupEntity entity, @MappingTarget BookmarkGroupDto dto) {
        entity.setGroupAdmin(new Gson().toJson(dto.getGroupAdmin()));
    }

    @AfterMapping
    public void mapDtoExtraInformation(BookmarkGroupDto dto, @MappingTarget BookmarkGroupEntity entity) {
        dto.setGroupAdmin(new Gson().fromJson(entity.getGroupAdmin(), List.class));
    }
}
