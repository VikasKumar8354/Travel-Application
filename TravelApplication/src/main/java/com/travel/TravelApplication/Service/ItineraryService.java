package com.travel.TravelApplication.Service;

import com.travel.TravelApplication.ExceptionHandling.ResourceNotFoundException;
import com.travel.TravelApplication.Model.Itinerary;
import com.travel.TravelApplication.Model.TourPackage;
import com.travel.TravelApplication.Repository.ItineraryRepository;
import com.travel.TravelApplication.Repository.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryService {

    @Autowired
    private final ItineraryRepository itineraryRepository;
    @Autowired
    private final TourPackageRepository tourPackageRepository;

    public ItineraryService(ItineraryRepository itineraryRepository, TourPackageRepository tourPackageRepository) {
        this.itineraryRepository = itineraryRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public List<Itinerary> findAll() {
        return itineraryRepository.findAll();
    }
    public Itinerary findById(Long id) {
        return itineraryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Itinerary not found: " + id));
    }
    public Itinerary create(Long tourPackageId, Itinerary itinerary) {
        TourPackage tourPackage = tourPackageRepository.findById(tourPackageId)
                .orElseThrow(() -> new ResourceNotFoundException("Tour package not found: " + tourPackageId));

        itinerary.setTourPackage(tourPackage);

        return itineraryRepository.save(itinerary);
    }

    public List<Itinerary> findByTourPackage(Long tourPackageId) {
        return itineraryRepository.findByTourPackageId(tourPackageId);
    }

    public void delete(Long id) {
        itineraryRepository.deleteById(id); }
}
