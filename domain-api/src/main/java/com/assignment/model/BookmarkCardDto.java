package com.assignment.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class BookmarkCardDto implements Serializable {
    private Long id;

    private String title;

    private String description;

    private String shortUrl;

    private String longUrl;

    private String fevicon;

    private LocalDate expiryDate;

    private boolean approved;

    BookmarkGroupDto bookmarkGroup;

    private String createdBy;

    private LocalDateTime creationDate;

    private String modifiedBy;

    private LocalDateTime modifiedDate;
}
