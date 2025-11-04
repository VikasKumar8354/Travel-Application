package com.travel.TravelApplication.Controller;

import com.travel.TravelApplication.Model.Destination;
import com.travel.TravelApplication.Service.DestinationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destination")
public class DestinationController {

    private final DestinationService service;
    public DestinationController(DestinationService service) { this.service = service; }

    @GetMapping
    public List<Destination> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Destination getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Destination create(@RequestBody Destination d) { return service.create(d); }

    @PutMapping("/{id}")
    public Destination update(@PathVariable Long id, @RequestBody Destination d) { return service.update(id, d); }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) { service.delete(id); return "Deleted"; }
}
