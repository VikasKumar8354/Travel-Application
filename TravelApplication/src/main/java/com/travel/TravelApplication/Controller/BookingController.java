package com.travel.TravelApplication.Controller;

import com.travel.TravelApplication.DTOs.BookingRequest;
import com.travel.TravelApplication.Model.Booking;
import com.travel.TravelApplication.Service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService service;
    public BookingController(BookingService service) { this.service = service; }

    @GetMapping
    public List<Booking> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Booking get(@PathVariable Long id) { return service.findById(id); }

    @GetMapping("/user/{userId}")
    public List<Booking> byUser(@PathVariable Long userId) { return service.findByUser(userId); }

    @PostMapping
    public Booking create(@RequestBody BookingRequest req) {
        return service.create(req.getUserId(), req.getDestinationId(), req.getNumberOfPeople(), req.getBookingDate());
    }

    @PostMapping("/{id}/cancel")
    public String cancel(@PathVariable Long id) {
        service.cancel(id);
        return "Cancelled";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) { service.delete(id); return "Deleted"; }
}
