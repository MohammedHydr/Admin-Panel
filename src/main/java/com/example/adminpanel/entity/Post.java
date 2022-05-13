package com.example.adminpanel.entity;


import javax.persistence.*;
import java.util.Base64;

@Entity // make this java class a jpa entity
@Table(name = "posts") // map this entity to database table
public class Post {

    @Id // specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // provides for the specification of generation strategies for the values of primary keys
    private long post_id;

    @Column(nullable = true)
    private String comment;

    @Lob //specifies that the database should store the property as Large Object
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="place_id", referencedColumnName = "place_id")
    private Place place;

    public Post() {
    }

    public Post(String comment, byte[] image, User user, Place place) {
        this.comment = comment;
        this.image = image;
        this.user = user;
        this.place = place;
    }

    public long getPost_id() {
        return post_id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String byteToString(byte[] image){
        return Base64.getEncoder().encodeToString(image);
    }
}
