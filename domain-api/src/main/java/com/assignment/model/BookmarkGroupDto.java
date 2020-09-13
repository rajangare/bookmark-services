package com.assignment.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class BookmarkGroupDto implements Serializable {
    private Long id;

    private String groupName;

    private String description;

    private String groupUrl;

    private List<UserDto> groupAdmin;

    private String createdBy;

    private LocalDateTime creationDate;

    private String modifiedBy;

    private LocalDateTime modifiedDate;
}
