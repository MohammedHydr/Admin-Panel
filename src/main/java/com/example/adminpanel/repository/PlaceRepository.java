package com.example.adminpanel.repository;

import com.example.adminpanel.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
//    List<Place> findPlaceByName(String pName);

//@Query(value = "select * from places s where s.name like %:keyword%", nativeQuery = true)
//List<Place> findByKeyword(@Param("keyword") String keyword);
}
