package com.travel.TravelApplication.Service;

import com.travel.TravelApplication.ExceptionHandling.ResourceNotFoundException;
import com.travel.TravelApplication.Model.Destination;
import com.travel.TravelApplication.Repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    @Autowired
    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<Destination> findAll() {
        return destinationRepository.findAll();
    }
    public Destination findById(Long id) {
        return destinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found: " + id));
    }
    public Destination create(Destination destination) {
        return destinationRepository.save(destination);
    }
    public Destination update(Long id, Destination updated) {

        Destination destination = findById(id);
        destination.setName(updated.getName());
        destination.setCountry(updated.getCountry());
        destination.setPrice(updated.getPrice());
        destination.setDescription(updated.getDescription());

        return destinationRepository.save(destination);
    }
    public void delete(Long id) {
        destinationRepository.deleteById(id);
    }
}
