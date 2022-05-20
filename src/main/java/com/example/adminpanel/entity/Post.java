package com.example.adminpanel.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Entity // make this java class a jpa entity
@Table(name = "posts") // map this entity to database table
public class Post implements Serializable {

    @Id // specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // provides for the specification of generation strategies for the values of primary keys
    private long post_id;

    @Column(nullable = true)
    private String comment;

    @Lob //specifies that the database should store the property as Large Object
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] image;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="user_id", referencedColumnName = "id")
//    private User user;

    @Column(nullable = true)
    private String  place;

    @Column(nullable = true)
    private long  user;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "placeName", referencedColumnName = "name")
//    private Place place;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (post_id != post.post_id) return false;
        if (!Objects.equals(comment, post.comment)) return false;
        if (!Arrays.equals(image, post.image)) return false;
        if (!Objects.equals(user, post.user)) return false;
        return Objects.equals(place, post.place);
    }

    @Override
    public int hashCode() {
        int result = (int) (post_id ^ (post_id >>> 32));
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (int) (user ^ (user >>> 32));
        return result;
    }

    public Post() {
    }

    public Post(String comment, byte[] image, String place) {
        this.comment = comment;
        this.image = image;
//        this.user = user;
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

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", comment='" + comment + '\'' +
                ", image=" + Arrays.toString(image) +
                ", user=" + user +
                ", place=" + place +
                '}';
    }

    public String byteToString(byte[] image){
        return Base64.getEncoder().encodeToString(image);
    }
}
