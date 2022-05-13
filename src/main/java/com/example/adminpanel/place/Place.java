package com.example.adminpanel.place;

import com.example.adminpanel.category.Category;

import javax.persistence.*;
import java.util.Base64;

@Entity // make this java class a jpa entity
@Table(name = "places") // map this entity to database table
public class Place {

    @Id // specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // provides for the specification of generation strategies for the values of primary keys
    private long place_id;

    @Column(nullable = false, unique = true) // is used for Adding the column the name in the table of a particular MySQL database unique and not null
    private String name;

    @Column(nullable = true)
    private String city_name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Double latitude;

    @Lob //specifies that the database should store the property as Large Object
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cat_id", referencedColumnName = "category_id")
    private Category category;

    public Place() {
    }

    public Place(String name, String city_name, String description, Double longitude, Double latitude, byte[] image, Category category) {
        this.name = name;
        this.city_name = city_name;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.image = image;
        this.category = category;
    }

    public long getPlace_id() {
        return place_id;
    }

    public void setPlace_id(long place_id) {
        this.place_id = place_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String byteToString(byte[] image){
        return Base64.getEncoder().encodeToString(image);
    }
}
