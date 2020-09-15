package com.assignment.bookmark.mapper;

import com.assignment.entity.BookmarkGroupEntity;
import com.assignment.model.BookmarkGroupDto;
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
    public abstract List<BookmarkGroupDto> mapGroupDetailsDtoList(List<BookmarkGroupEntity> groupDetailsEntities);

    @InheritInverseConfiguration(name = "mapOneGroupDetail")
    public abstract BookmarkGroupDto mapGroupDetailDto(BookmarkGroupEntity BookmarkGroupEntity);

    @AfterMapping
    public void mapToDtoExtraInformation(BookmarkGroupEntity source, @MappingTarget BookmarkGroupDto target) {
        target.setGroupAdmin(new Gson().fromJson(source.getGroupAdminDetails(), List.class));
    }

    @AfterMapping
    public void mapToEntityExtraInformation(BookmarkGroupDto source, @MappingTarget BookmarkGroupEntity target) {
        target.setGroupAdminDetails(new Gson().toJson(source.getGroupAdmin()));
    }
}
