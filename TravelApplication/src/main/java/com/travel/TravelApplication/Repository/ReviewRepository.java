package com.travel.TravelApplication.Repository;

import com.travel.TravelApplication.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByDestinationId(Long destinationId);
}
