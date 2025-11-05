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

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping("/getAll")
    public List<Destination> getAll() {
        return destinationService.findAll();
    }

    @GetMapping("/getById/{id}")
    public Destination getById(@PathVariable Long id) {
        return destinationService.findById(id);
    }

    @PostMapping("/create")
    public Destination create(@RequestBody Destination destination) {
        return destinationService.create(destination);
    }

    @PutMapping("/update/{id}")
    public Destination update(@PathVariable Long id, @RequestBody Destination destination) {
        return destinationService.update(id, destination);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        destinationService.delete(id); return "Deleted";
    }
}
