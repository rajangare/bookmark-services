package com.assignment.port;

import com.assignment.model.BookmarkCardDto;

import java.util.List;

public interface BookmarkCardPort {
    BookmarkCardDto findBookmarkCardById(Long bookmarkId);

    List<BookmarkCardDto> findAllBookmarkCards();

    BookmarkCardDto saveOrUpdateBookmarkCard(BookmarkCardDto bookmarkCardDto);

    void deleteBookmarkCard(Long bookmarkId);
}
