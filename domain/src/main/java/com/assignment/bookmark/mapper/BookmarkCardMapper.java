package com.assignment.bookmark.mapper;

import com.assignment.entity.BookmarkCardEntity;
import com.assignment.model.BookmarkCardDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
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
}
