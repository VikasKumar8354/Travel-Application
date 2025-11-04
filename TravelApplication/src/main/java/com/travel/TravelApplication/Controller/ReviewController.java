package com.travel.TravelApplication.Controller;

import com.travel.TravelApplication.Model.Review;
import com.travel.TravelApplication.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<Review> getAll() {
        return service.findAll();
    }

    @GetMapping("/getById/{id}")
    public Review get(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/destination/{destinationId}")
    public List<Review> byDestination(@PathVariable Long destinationId) {
        return service.findByDestination(destinationId);
    }

    @PostMapping("/add")
    public Review add(@RequestBody Map<String,Object> payload) {

        Long userId = Long.valueOf(payload.get("userId").toString());
        Long destinationId = Long.valueOf(payload.get("destinationId").toString());
        int rating = Integer.parseInt(payload.get("rating").toString());
        String comment = payload.get("comment").toString();
        return service.addReview(userId, destinationId, rating, comment);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id); return "Deleted";
    }
}

