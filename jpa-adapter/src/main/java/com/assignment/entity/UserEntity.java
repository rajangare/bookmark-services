package com.assignment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "UserEntity")
@Table(name = "T_USER_BMK")
public class UserEntity {
    @Id
    @SequenceGenerator(name = "seqBookmarkUser", sequenceName = "SEQ_USER_BMK", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqBookmarkUser")
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;
}
