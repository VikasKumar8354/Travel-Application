package com.travel.TravelApplication.Controller;

import com.travel.TravelApplication.DTOs.BookingRequest;
import com.travel.TravelApplication.Model.Booking;
import com.travel.TravelApplication.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<Booking> getAll() {
        return service.findAll();
    }

    @GetMapping("/getById/{id}")
    public Booking getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> byUser(@PathVariable Long userId) {
        return service.findByUser(userId); }

    @PostMapping("/create")
    public Booking create(@RequestBody BookingRequest bookingRequest) {
        return service.create(bookingRequest.getUserId(), bookingRequest.getDestinationId(), bookingRequest.getNumberOfPeople(), bookingRequest.getBookingDate());
    }

    @PostMapping("/cancel/{id}")
    public String cancel(@PathVariable Long id) {
        service.cancel(id);
        return "Cancelled";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) { service.delete(id); return "Deleted"; }
}
