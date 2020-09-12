package com.assignment.port;

import com.assignment.model.BookmarkCardGroupDto;

import java.util.List;

public interface BookmarkCardGroupPort {
    BookmarkCardGroupDto findCardGroupById(Long cardGroupId);

    List<BookmarkCardGroupDto> findAllCardGroups();

    BookmarkCardGroupDto saveOrUpdateCardGroup(BookmarkCardGroupDto bookmarkCardDto);

    void deleteCardGroup(Long cardGroupId);
}
