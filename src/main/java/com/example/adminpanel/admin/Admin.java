package com.example.adminpanel.admin;



import javax.persistence.*;
@Entity // make this java class a jpa entity
@Table(name = "admins") // map this entity to database table
public class Admin {

    @Id // specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // provides for the specification of generation strategies for the values of primary keys
    private Long id; // GenerationType.IDENTITY means they are auto-incremented

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;


    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
