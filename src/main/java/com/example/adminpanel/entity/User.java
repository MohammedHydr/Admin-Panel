package com.example.adminpanel.entity;

import javax.persistence.*;

@Entity // make this java class a jpa entity
@Table(name = "users") // map this entity to database table
public class User {
    @Id // specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // provides for the specification of generation strategies for the values of primary keys
    private Long id;

    @Column(nullable = false, unique = true) // is used for Adding the column the name in the table of a particular MySQL database unique and not null
    private String email;

    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
