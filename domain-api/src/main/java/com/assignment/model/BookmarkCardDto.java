package com.assignment.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class BookmarkCardDto implements Serializable {
    private Long id;

    private String title;

    private String description;

    private String shortUrl;

    private String actualUrl;

    private String fevicon;

    private String createdBy;

    private LocalDate creationDate;

    private String modifiedBy;

    private LocalDate modifiedDate;

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
