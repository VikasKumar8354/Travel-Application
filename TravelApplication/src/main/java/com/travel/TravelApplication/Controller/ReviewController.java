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
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/getAll")
    public List<Review> getAll() {
        return reviewService.findAll();
    }

    @GetMapping("/getById/{id}")
    public Review get(@PathVariable Long id) {
        return reviewService.findById(id);
    }

    @GetMapping("/destination/{destinationId}")
    public List<Review> byDestination(@PathVariable Long destinationId) {
        return reviewService.findByDestination(destinationId);
    }

    @PostMapping("/add")
    public Review add(@RequestBody Map<String,Object> payload) {

        Long userId = Long.valueOf(payload.get("userId").toString());
        Long destinationId = Long.valueOf(payload.get("destinationId").toString());
        int rating = Integer.parseInt(payload.get("rating").toString());
        String comment = payload.get("comment").toString();
        return reviewService.addReview(userId, destinationId, rating, comment);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        reviewService.delete(id); return "Deleted";
    }
}

