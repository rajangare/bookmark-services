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

    private String actualUrl;

    private String fevicon;

    private LocalDate expiryDate;

    private String createdBy;

    private LocalDateTime creationDate;

    private String modifiedBy;

    private LocalDateTime modifiedDate;

    @Override
    public String toString() {
        return "BookmarkCardDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", actualUrl='" + actualUrl + '\'' +
                ", fevicon='" + fevicon + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate=" + creationDate +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
