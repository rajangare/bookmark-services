package com.assignment.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "BookmarkGroupEntity")
@Table(name = "T_GROUP_BMK")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class BookmarkGroupEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "seqGroupDetails", sequenceName = "SEQ_GROUP_BMK", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGroupDetails")
    @Column(name = "ID")
    private Long id;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "GROUP_URL")
    private String groupUrl;

    @Type(type = "jsonb")
    @Column(name = "GROUP_ADMIN", columnDefinition = "jsonb")
    private String groupAdminDetails;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;
}
