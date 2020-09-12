package com.assignment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "BookmarkCardEntity")
@Table(name = "T_BOOKMARK_CARD")
public class BookmarkCardEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "seqBookmarkCardDetails", sequenceName = "SEQ_T_BOOKMARK_CARD", initialValue = 1, allocationSize = 100)
    @GeneratedValue(generator = "seqBookmarkCardDetails")
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SHORT_URL")
    private String shortUrl;

    @Column(name = "ACTUAL_URL")
    private String actualUrl;

    @Column(name = "FEVICON")
    private String fevicon;

    @Column(name = "EXPIRY_DATE")
    private LocalDate expiryDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;
}
