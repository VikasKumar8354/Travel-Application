package com.travel.TravelApplication.Controller;

import com.travel.TravelApplication.Model.Itinerary;
import com.travel.TravelApplication.Model.TourPackage;
import com.travel.TravelApplication.Service.ItineraryService;
import com.travel.TravelApplication.Service.TourPackageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/TourPackage")
public class TourPackageController {

    private final TourPackageService service;
    private final ItineraryService itineraryService;

    public TourPackageController(TourPackageService service, ItineraryService itineraryService) {
        this.service = service; this.itineraryService = itineraryService;
    }

    @GetMapping
    public List<TourPackage> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public TourPackage get(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public TourPackage create(@RequestBody TourPackage p) { return service.create(p); }

    @PutMapping("/{id}")
    public TourPackage update(@PathVariable Long id, @RequestBody TourPackage p) { return service.update(id, p); }

    @DeleteMapping("/{id}")
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
