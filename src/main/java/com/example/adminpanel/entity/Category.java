package com.example.adminpanel.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity // make this java class a jpa entity
@Table(name = "categories") // map this entity to database table
public class Category implements Serializable {

    @Id // specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // provides for the specification of generation strategies for the values of primary keys
    private Long category_id;

    @Column(nullable = false, unique = true) // is used for Adding the column the name in the table of a particular MySQL database unique and not null
    private String name;


    public Category() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (!category_id.equals(category.category_id)) return false;
        return name.equals(category.name);
    }

    @Override
    public int hashCode() {
        int result = category_id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
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

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", name='" + name + '\'' +
                '}';
    }
}
