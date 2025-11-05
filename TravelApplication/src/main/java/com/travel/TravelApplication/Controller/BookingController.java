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
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/getAll")
    public List<Booking> getAll() {
        return bookingService.findAll();
    }

    @GetMapping("/getById/{id}")
    public Booking getById(@PathVariable Long id) {
        return bookingService.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> byUser(@PathVariable Long userId) {
        return bookingService.findByUser(userId); }

    @PostMapping("/create")
    public Booking create(@RequestBody BookingRequest bookingRequest) {
        return bookingService.create(bookingRequest.getUserId(), bookingRequest.getDestinationId(), bookingRequest.getNumberOfPeople(), bookingRequest.getBookingDate());
    }

    @PostMapping("/cancel/{id}")
    public String cancel(@PathVariable Long id) {
        bookingService.cancel(id);
        return "Cancelled";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) { bookingService.delete(id); return "Deleted"; }
}
