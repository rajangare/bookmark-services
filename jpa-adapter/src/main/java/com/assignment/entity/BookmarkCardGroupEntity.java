package com.assignment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "BookmarkCardGroupEntity")
@Table(name = "T_BOOKMARK_CARD_GROUP")
public class BookmarkCardGroupEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "seqBookmarkCardDetails", sequenceName = "SEQ_T_BOOKMARK_CARD_GROUP", initialValue = 1, allocationSize = 100)
    @GeneratedValue(generator = "seqBookmarkCardDetails")
    @Column(name = "ID")
    private Long id;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "GROUP_URL")
    private String groupUrl;

    @Column(name = "TEAM")
    private String actualUrl;

    @Column(name = "CARDS")
    private String cards;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;
}
