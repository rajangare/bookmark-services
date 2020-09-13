package com.assignment.bookmark.mapper;

import com.assignment.entity.BookmarkCardEntity;
import com.assignment.model.BookmarkCardDto;
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
public abstract class BookmarkCardMapper {
    public abstract List<BookmarkCardEntity> mapCardDetailsList(List<BookmarkCardDto> bookmarkCardDtoList);

    public abstract BookmarkCardEntity mapOneCardDetail(BookmarkCardDto bookmarkCardDto);

    @InheritInverseConfiguration(name = "mapCardDetailsList")
    public abstract List<BookmarkCardDto> mapCardDetailsDtoList(List<BookmarkCardEntity> cardDetailsEntities);

    @InheritInverseConfiguration(name = "mapOneCardDetail")
    public abstract BookmarkCardDto mapCardDetailDto(BookmarkCardEntity bookmarkCardEntity);

    @AfterMapping
    public void mapEntityExtraInformation(BookmarkCardEntity entity, @MappingTarget BookmarkCardDto dto) {
        entity.setGroupDetails(new Gson().toJson(dto.getBookmarkGroup()));
    }

    @AfterMapping
    public void mapDtoExtraInformation(BookmarkCardDto dto, @MappingTarget BookmarkCardEntity entity) {
        dto.setBookmarkGroup(new Gson().fromJson(entity.getGroupDetails(), BookmarkGroupDto.class));
    }
}
