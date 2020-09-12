package com.assignment.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
public class BookmarkCardGroupDto implements Serializable {
    private Long id;

    private String groupName;

    private String description;

    private String groupUrl;

    private String actualUrl;

    private String cards;

    private String createdBy;

    private LocalDateTime creationDate;

    private String modifiedBy;

    private LocalDateTime modifiedDate;
}
