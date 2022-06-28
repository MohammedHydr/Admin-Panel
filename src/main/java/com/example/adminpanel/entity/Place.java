package com.example.adminpanel.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

@Entity // make this java class a jpa entity
@Table(name = "places") // map this entity to database table
public class Place implements Serializable {

    @Id // specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // provides for the specification of generation strategies for the values of primary keys
    private long place_id;

    @Column(nullable = false, unique = true) // is used for Adding the column the name in the table of a particular MySQL database unique and not null
    private String name;

    @Column(nullable = true)
    private String city_name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Double latitude;

    @Lob //specifies that the database should store the property as Large Object
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] image;

    private String category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (place_id != place.place_id) return false;
        if (!Objects.equals(name, place.name)) return false;
        if (!Objects.equals(city_name, place.city_name)) return false;
        if (!Objects.equals(description, place.description)) return false;
        if (!Objects.equals(longitude, place.longitude)) return false;
        if (!Objects.equals(latitude, place.latitude)) return false;
        if (!Arrays.equals(image, place.image)) return false;
        return Objects.equals(category, place.category);
    }

    @Override
    public int hashCode() {
        int result = (int) (place_id ^ (place_id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city_name != null ? city_name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    public Place() {
    }

    public Place(String name, String city_name, String description) {
        this.name = name;
        this.city_name = city_name;
        this.description = description;
    }

    public Place(String name, String city_name, String description, Double longitude, Double latitude, byte[] image, String category) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Place{" +
                "place_id=" + place_id +
                ", name='" + name + '\'' +
                ", city_name='" + city_name + '\'' +
                ", description='" + description + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", image=" + Arrays.toString(image) +
                ", category=" + category +
                '}';
    }

    public String byteToString(byte[] image){
        return Base64.getEncoder().encodeToString(image);
    }
}
