package com.example.adminpanel.category;

import com.example.adminpanel.place.Place;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity // make this java class a jpa entity
@Table(name = "categories") // map this entity to database table
public class Category {

    @Id // specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // provides for the specification of generation strategies for the values of primary keys
    private Long category_id;

    @Column(nullable = false, unique = true) // is used for Adding the column the name in the table of a particular MySQL database unique and not null
    private String name;


    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return category_id;
    }

    public void setId(Long category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
