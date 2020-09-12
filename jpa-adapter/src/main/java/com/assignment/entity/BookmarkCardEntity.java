package com.assignment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "CardDetailsEntity")
@Table(name = "T_CARD_DETAIL")
public class BookmarkCardEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "seqCardDetails", sequenceName = "SEQ_CARD_DETAIL", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "seqCardDetails")
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

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATION_DATE")
    private LocalDate creationDate;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "MODIFIED_DATE")
    private LocalDate modifiedDate;
}
