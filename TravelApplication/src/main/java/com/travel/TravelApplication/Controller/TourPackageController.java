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
    private final TourPackageService service;
    @Autowired
    private final ItineraryService itineraryService;

    public TourPackageController(TourPackageService service, ItineraryService itineraryService) {
        this.service = service;
        this.itineraryService = itineraryService;
    }

    @GetMapping("/getAll")
    public List<TourPackage> getAll() {
        return service.findAll();
    }

    @GetMapping("/getById/{id}")
    public TourPackage get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/create")
    public TourPackage create(@RequestBody TourPackage tourPackage) {
        return service.create(tourPackage);
    }

    @PutMapping("/update/{id}")
    public TourPackage update(@PathVariable Long id, @RequestBody TourPackage tourPackage) {
        return service.update(id, tourPackage);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) { service.delete(id); return "Deleted"; }

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
