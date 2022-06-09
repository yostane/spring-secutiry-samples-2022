package com.lecture.springsec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String role;
}
