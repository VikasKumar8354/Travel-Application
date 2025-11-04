package com.travel.TravelApplication.Service;

import com.travel.TravelApplication.ExceptionHandling.ResourceNotFoundException;
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
    private  UserRepository userRepository;
    private  DestinationRepository destinationRepository;

    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, DestinationRepository destinationRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.destinationRepository = destinationRepository;
    }

    public List<Booking> findAll() { return bookingRepository.findAll(); }
    public Booking findById(Long id) { return bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking not found: " + id)); }
    public List<Booking> findByUser(Long userId) { return bookingRepository.findByUserId(userId); }

    public Booking create(Long userId, Long destinationId, int numberOfPeople, LocalDate bookingDate) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));
        Destination destination = destinationRepository.findById(destinationId).orElseThrow(() -> new ResourceNotFoundException("Destination not found: " + destinationId));
        Booking booking = new Booking(LocalDate.now(), LocalDate.now().plusDays(7), numberOfPeople, user, destination);

        booking.setStatus("CONFIRMED");
        return bookingRepository.save(booking);
    }

    public void cancel(Long bookingId) {
        Booking b = findById(bookingId);
        b.setStatus("CANCELLED");
        bookingRepository.save(b);
    }

    public void delete(Long id) { bookingRepository.deleteById(id); }
}
