package com.travel.TravelApplication.Service;

import com.travel.TravelApplication.ExceptionHandling.ResourceNotFoundException;
import com.travel.TravelApplication.Model.Itinerary;
import com.travel.TravelApplication.Model.TourPackage;
import com.travel.TravelApplication.Repository.ItineraryRepository;
import com.travel.TravelApplication.Repository.TourPackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryService {

    private ItineraryRepository itineraryRepository;
    private  TourPackageRepository tourPackageRepository;

    public ItineraryService(ItineraryRepository repo, TourPackageRepository tourRepo) { this.itineraryRepository = repo; this.tourPackageRepository = tourRepo; }

    public List<Itinerary> findAll() { return itineraryRepository.findAll(); }
    public Itinerary findById(Long id) { return itineraryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Itinerary not found: " + id)); }
    public Itinerary create(Long tourPackageId, Itinerary itinerary) {
        TourPackage tp = tourPackageRepository.findById(tourPackageId).orElseThrow(() -> new ResourceNotFoundException("Tour package not found: " + tourPackageId));
        itinerary.setTourPackage(tp);
        return itineraryRepository.save(itinerary);
    }
    public List<Itinerary> findByTourPackage(Long tourPackageId) {
        return itineraryRepository.findByTourPackageId(tourPackageId);
    }

    public void delete(Long id) { itineraryRepository.deleteById(id); }

}
