package com.travel.TravelApplication.Service;

import com.travel.TravelApplication.ExceptionHandling.ResourceNotFoundException;
import com.travel.TravelApplication.Model.TourPackage;
import com.travel.TravelApplication.Repository.TourPackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourPackageService {

    private  TourPackageRepository tourPackageRepository;
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public List<TourPackage> findAll() { return tourPackageRepository.findAll(); }
    public TourPackage findById(Long id) { return tourPackageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Package not found: " + id)); }
    public TourPackage create(TourPackage p) { return tourPackageRepository.save(p); }
    public TourPackage update(Long id, TourPackage updated) {
        TourPackage p = findById(id);
        p.setTitle(updated.getTitle());
        p.setPrice(updated.getPrice());
        p.setDurationDays(updated.getDurationDays());
        p.setDescription(updated.getDescription());
        return tourPackageRepository.save(p);
    }
    public void delete(Long id) { tourPackageRepository.deleteById(id); }
}
