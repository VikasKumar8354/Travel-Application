package com.travel.TravelApplication.Service;

import com.travel.TravelApplication.Model.Booking;
import com.travel.TravelApplication.Model.Destination;
import com.travel.TravelApplication.Model.User;
import com.travel.TravelApplication.Repository.BookingRepository;
import com.travel.TravelApplication.Repository.DestinationRepository;
import com.travel.TravelApplication.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {


    private  BookingRepository bookingRepository;
    private UserRepository userRepository;
    private DestinationRepository destinationRepository;

    public BookingService(BookingRepository bookingRepository,UserRepository userRepository,DestinationRepository destinationRepository){
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.destinationRepository = destinationRepository;

    }

    public List<Booking> getAllBooking(){
        return bookingRepository.findAll();
    }

    public Booking createBooking(Long userId, Long destinationId, int persons) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Destination destination = destinationRepository.findById(destinationId)
                .orElseThrow(() -> new RuntimeException("Destination not found"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setDestination(destination);
        booking.setBookingDate(LocalDate.now());
        booking.setPersons(persons);
        booking.setTotalCost(destination.getPrice() * persons);

        return bookingRepository.save(booking);
    }
}
