package com.assignment.port;

import com.assignment.model.BookmarkGroupDto;

import java.util.List;

public interface BookmarkGroupPort {
    BookmarkGroupDto findCardGroupById(Long cardGroupId);

    List<BookmarkGroupDto> findAllCardGroups();

    BookmarkGroupDto saveOrUpdateCardGroup(BookmarkGroupDto bookmarkCardDto);

    void deleteCardGroup(Long cardGroupId);
}
