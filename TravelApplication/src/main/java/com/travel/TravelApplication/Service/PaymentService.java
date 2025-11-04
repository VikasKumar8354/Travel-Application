package com.travel.TravelApplication.Service;

import com.travel.TravelApplication.ExceptionHandling.ResourceNotFoundException;
import com.travel.TravelApplication.Model.Booking;
import com.travel.TravelApplication.Model.Payment;
import com.travel.TravelApplication.Repository.BookingRepository;
import com.travel.TravelApplication.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {

    private  PaymentRepository paymentRepository;
    private  BookingRepository bookingRepository;

    public PaymentService(PaymentRepository paymentRepository, BookingRepository bookingRepository) {
        this.paymentRepository = paymentRepository;
        this.bookingRepository = bookingRepository;
    }

    public List<Payment> findAll() { return paymentRepository.findAll(); }
    public Payment findById(Long id) { return paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment not found: " + id)); }

    public Payment makePayment(Long bookingId, double amount, String paymentMode) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Booking not found: " + bookingId));
        Payment payment = new Payment(amount, LocalDate.now(), paymentMode,"SUCCESS" , booking);
        booking.setPayment(payment);
        return paymentRepository.save(payment);
    }

    public void delete(Long id) { paymentRepository.deleteById(id); }
}
