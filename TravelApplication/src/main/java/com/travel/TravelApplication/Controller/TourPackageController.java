package com.travel.TravelApplication.Controller;

import com.travel.TravelApplication.Model.Itinerary;
import com.travel.TravelApplication.Model.TourPackage;
import com.travel.TravelApplication.Service.ItineraryService;
import com.travel.TravelApplication.Service.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/TourPackage")
public class TourPackageController {

    @Autowired
    private final TourPackageService tourPackageService;
    @Autowired
    private final ItineraryService itineraryService;

    public TourPackageController(TourPackageService tourPackageService, ItineraryService itineraryService) {
        this.tourPackageService = tourPackageService;
        this.itineraryService = itineraryService;
    }

    @GetMapping("/getAll")
    public List<TourPackage> getAll() {
        return tourPackageService.findAll();
    }

    @GetMapping("/getById/{id}")
    public TourPackage get(@PathVariable Long id) {
        return tourPackageService.findById(id);
    }

    @PostMapping("/create")
    public TourPackage create(@RequestBody TourPackage tourPackage) {
        return tourPackageService.create(tourPackage);
    }

    @PutMapping("/update/{id}")
    public TourPackage update(@PathVariable Long id, @RequestBody TourPackage tourPackage) {
        return tourPackageService.update(id, tourPackage);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        tourPackageService.delete(id); return "Deleted"; }

    // Itinerary endpoints
    @PostMapping("/{packageId}/itineraries")
    public Itinerary addItinerary(@PathVariable Long packageId, @RequestBody Itinerary itinerary) {
        return itineraryService.create(packageId, itinerary);
    }

    @GetMapping("/{packageId}/itineraries")
    public List<Itinerary> packageItineraries(@PathVariable Long packageId) {
        return itineraryService.findByTourPackage(packageId);
    }
}
