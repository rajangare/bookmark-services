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
    public void mapToDtoExtraInformation(BookmarkCardEntity source, @MappingTarget BookmarkCardDto target) {
        target.setBookmarkGroup(new Gson().fromJson(source.getGroupDetail(), BookmarkGroupDto.class));
    }

    @AfterMapping
    public void mapToEntityExtraInformation(BookmarkCardDto source, @MappingTarget BookmarkCardEntity target) {
        target.setGroupDetail(new Gson().toJson(source.getBookmarkGroup()));
    }
}
