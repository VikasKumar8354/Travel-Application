package com.travel.TravelApplication.Controller;

import com.travel.TravelApplication.Model.Destination;
import com.travel.TravelApplication.Service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destination")
public class DestinationController {

    @Autowired
    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService){
        this.destinationService = destinationService;
    }

    @PostMapping("/add")
    public Destination add(@RequestBody Destination destination){
        return destinationService.addDestination(destination);
    }

    @GetMapping("/getAll")
    public List<Destination> getAll(){
        return destinationService.getAllDestination();
    }

    @GetMapping("/getById/{id}")
    public Destination getById(@PathVariable Long id){
        return destinationService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        destinationService.deleteDestination(id);
    }
}
