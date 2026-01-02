package com.travel.TravelApplication.Service;

import com.travel.TravelApplication.ExceptionHandling.ResourceNotFoundException;
import com.travel.TravelApplication.Model.Destination;
import com.travel.TravelApplication.Model.Review;
import com.travel.TravelApplication.Model.User;
import com.travel.TravelApplication.Repository.DestinationRepository;
import com.travel.TravelApplication.Repository.ReviewRepository;
import com.travel.TravelApplication.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final DestinationRepository destinationRepository;
    private final UserRepository userRepository;

    public ReviewService(ReviewRepository reviewRepository, DestinationRepository destinationRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.destinationRepository = destinationRepository;
        this.userRepository = userRepository;
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found: " + id));
    }

    public List<Review> findByDestination(Long destinationId) {
        return reviewRepository.findByDestinationId(destinationId);
    }

    public Review addReview(Long userId, Long destinationId, int rating, String comment) {

        Destination destination = destinationRepository.findById(destinationId)
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found: " + destinationId));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));
        Review review = new Review(rating, comment, destination, user);

        return reviewRepository.save(review);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
