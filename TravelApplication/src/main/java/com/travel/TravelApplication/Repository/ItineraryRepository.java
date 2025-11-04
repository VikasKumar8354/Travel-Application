package com.travel.TravelApplication.Repository;

import com.travel.TravelApplication.Model.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary,Long> {
    List<Itinerary> findByTourPackageId(Long tourPackageId);
}
