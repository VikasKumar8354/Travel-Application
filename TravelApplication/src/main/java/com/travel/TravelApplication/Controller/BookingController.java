package com.travel.TravelApplication.Controller;

import com.travel.TravelApplication.Model.Booking;
import com.travel.TravelApplication.Service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getAll(){
        return bookingService.getAllBooking();
    }

    @PostMapping("/user/{userId}/destination/{destinationId}")
    public Booking bookTrip(@PathVariable Long userId,
                            @PathVariable Long destinationId,
                            @RequestParam int persons){
        return bookingService.createBooking(userId,destinationId,persons);
    }
}
