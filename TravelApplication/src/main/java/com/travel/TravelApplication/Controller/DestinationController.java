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
    private final DestinationService service;

    public DestinationController(DestinationService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<Destination> getAll() {
        return service.findAll();
    }

    @GetMapping("/getById/{id}")
    public Destination getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/create")
    public Destination create(@RequestBody Destination destination) {
        return service.create(destination);
    }

    @PutMapping("/update/{id}")
    public Destination update(@PathVariable Long id, @RequestBody Destination destination) {
        return service.update(id, destination);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id); return "Deleted";
    }
}
