package com.example.adminpanel.repository;

import com.example.adminpanel.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
//    List<Place> findPlaceByName(String pName);
}
