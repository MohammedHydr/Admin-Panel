package com.example.adminpanel.controller;

import com.example.adminpanel.entity.Place;
import com.example.adminpanel.service.CategoryService;
import com.example.adminpanel.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j(topic = "PRODUCT_CONTROLLER")
@Controller
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private CategoryService categoryService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    // handler method to handle list places amd return model and view
    @GetMapping("/places")
    public String listPlaces(Model model, HttpSession session) {
        //keys and values , access this key using thymeleaf syntax ${listPlaces}
        model.addAttribute("listPlaces", placeService.getAllPlaces());
        return "place/places";
    }

    @GetMapping("/places/new")
    public String createPlaceForm(Model model) {
        // create user object to hold user from data
        Place place = new Place();
        model.addAttribute("addCategory",categoryService.getAllCategories());
        model.addAttribute("addPlace", place);
        return "place/create_place";
    }

    @PostMapping("/places")
    public String savePlace(@ModelAttribute("places") Place place,
                            @RequestParam("file") MultipartFile file) throws IOException {

        byte[] contents = file.getBytes();
        place.setImage(contents);
        placeService.savePlace(place);
        return "redirect:/places";
    }

    @GetMapping("/places/edit/{id}")
    public String editPlaceForm(@PathVariable Long id, Model model) {
        model.addAttribute("editPlace", placeService.getPlaceById(id));
        model.addAttribute("addCategory",categoryService.getAllCategories());
        return "place/edit_place";
    }

    @PostMapping("/places/{id}")
    public String updatePlace(@PathVariable Long id, @ModelAttribute("updatePlace") Place place,
                              @RequestParam("file") MultipartFile file) throws IOException{
        Place existingPlace = placeService.getPlaceById(id);
        existingPlace.setPlace_id(id);
        existingPlace.setName(place.getName());
        existingPlace.setCity_name(place.getCity_name());
        existingPlace.setDescription(place.getDescription());
        existingPlace.setLongitude(place.getLongitude());
        existingPlace.setLatitude(place.getLatitude());
        byte[] contents = file.getBytes();
        existingPlace.setImage(contents);
        existingPlace.setCategory(place.getCategory());
        placeService.updatePlace(existingPlace);
        return "redirect:/places";
    }

    //handler method to handle delete place request
    @GetMapping("/places/{id}")
    public String deletePlace(@PathVariable Long id){
        placeService.deletePlace(id);
        return "redirect:/places";
    }
//    @GetMapping("/places/display/{id}")
//    public String showContent(@PathVariable(value = "id") long id, Model model) throws
//            UnsupportedEncodingException {
//
//        if (placeService.getPlaceById(id) != null) {
//            return "redirect:/post_not_exist";
//        }
//        Optional <Place> place = Optional.ofNullable(placeService.getPlaceById(id));
//        ArrayList<Place> places = new ArrayList<>();
//        place.ifPresent(places::add);
//        model.addAttribute("post", places);
//
//
//        byte[] encodeBase64 = Base64.getEncoder().encode(place.get().getImage());
//        String base64Encoded = new String(encodeBase64, "UTF-8");
//        model.addAttribute("contentImage", base64Encoded );
//        return "post_content";
//    }
////@GetMapping("/places/{id}")
//@ResponseBody
//void showImage(@PathVariable("id") Long id, HttpServletResponse response, Place place)
//        throws ServletException, IOException {
//
//    place = placeService.getPlaceById(id);
//    response.setContentType("image/png");
//    response.getOutputStream().write(place.getImage());
//    response.getOutputStream().close();
// }
//    @GetMapping(path = {"/places/search/"})
//    public String home(Place place, Model model, String keyword) {
//        if(keyword!=null) {
//            List<Place> list = placeService.getByKeyword(keyword);
//            model.addAttribute("list", list);
//        }
//        else {
//            List<Place> list = placeService.getAllPlaces();
//            model.addAttribute("list", list);
//        }
//        return "place/places";
//
//    }
}
