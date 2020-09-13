package com.assignment.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class BookmarkCardResponse implements Serializable {
    private List<BookmarkCardDto> bookmarkCards;
}
