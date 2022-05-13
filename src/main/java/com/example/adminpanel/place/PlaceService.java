package com.example.adminpanel.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public void savePlace(Place place){
        placeRepository.save(place);
    }

    public Place getPlaceById(long id) {
        return placeRepository.findById(id).get();
    }

    public void updatePlace(Place place) {
        placeRepository.save(place);
    }

    public void deletePlace(Long id){
        placeRepository.deleteById(id);
    }

}
