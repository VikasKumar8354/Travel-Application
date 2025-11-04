package com.travel.TravelApplication.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private double amount;
    private LocalDate paymentDate;
    private String paymentMode;
    private String paymentStatus;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public Payment() {}

    // ✅ Constructor without id — this is the one your service needs
    public Payment(double amount, LocalDate paymentDate, String paymentMode, String paymentStatus, Booking booking) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
        this.booking = booking;
    }

    // (Optional) existing constructor with id — keep it if needed
    public Payment(Long id, double amount, LocalDate paymentDate, String paymentMode, String paymentStatus, Booking booking) {
        this.id = id;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
        this.booking = booking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
