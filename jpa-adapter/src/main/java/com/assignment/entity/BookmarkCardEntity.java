package com.assignment.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "BookmarkCardEntity")
@Table(name = "T_CARD_BMK")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class BookmarkCardEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "seqBookmarkCardDetails", sequenceName = "SEQ_CARD_BMK", initialValue = 1, allocationSize = 100)
    @GeneratedValue(generator = "seqBookmarkCardDetails")
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SHORT_URL")
    private String shortUrl;

    @Column(name = "LONG_URL")
    private String longUrl;

    @Column(name = "FEVICON")
    private String fevicon;

    @Column(name = "EXPIRY_DATE")
    private LocalDate expiryDate;

    @Column(name = "APPROVED")
    private boolean approved;

    @Type(type = "jsonb")
    @Column(name = "GROUP_DETAIL", columnDefinition = "jsonb")
    private String groupDetails;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;
}
