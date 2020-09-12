package com.assignment.bookmark.mapper;

import com.assignment.entity.BookmarkCardGroupEntity;
import com.assignment.model.BookmarkCardGroupDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public abstract class BookmarkCardGroupMapper {
    public abstract List<BookmarkCardGroupEntity> mapGroupDetailsList(List<BookmarkCardGroupDto> BookmarkCardGroupDtoList);

    public abstract BookmarkCardGroupEntity mapOneGroupDetail(BookmarkCardGroupDto BookmarkCardGroupDto);

    @InheritInverseConfiguration(name = "mapGroupDetailsList")
    public abstract List<BookmarkCardGroupDto> mapGroupDetailsDtoList(List<BookmarkCardGroupEntity> cardDetailsEntities);

    @InheritInverseConfiguration(name = "mapOneGroupDetail")
    public abstract BookmarkCardGroupDto mapGroupDetailDto(BookmarkCardGroupEntity BookmarkCardGroupEntity);
}
