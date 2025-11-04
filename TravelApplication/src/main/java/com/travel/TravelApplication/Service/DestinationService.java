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
    private DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository){
        this.destinationRepository = destinationRepository;
    }


    public Destination addDestination(Destination destination){
        return destinationRepository.save(destination);
    }

    public List<Destination> getAllDestination(){
        return destinationRepository.findAll();
    }

    public Destination getById(Long id){
        return destinationRepository.findById(id) .orElseThrow(() -> new ResourceNotFoundException("Destination Not Fond"));
    }

    public void deleteDestination(Long id){
        destinationRepository.deleteById(id);
    }
}
