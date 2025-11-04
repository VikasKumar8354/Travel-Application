package com.travel.TravelApplication.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
    private Payment payment;

    private LocalDate bookingDate;
    private int persons;
    private LocalDate travelDate;
    private String status;

    public Booking() {}

    public Booking(Long id, User user, Destination destination, Payment payment, LocalDate travelDate, int persons, String status) {
        this.id = id;
        this.user = user;
        this.destination = destination;
        this.travelDate = travelDate;
        this.payment = payment;
        this.persons = persons;
        this.status = status;
    }

    public Booking(LocalDate bookingDate, LocalDate travelDate, int persons, User user, Destination destination) {
        this.bookingDate = bookingDate;
        this.persons = persons;
        this.user = user;
        this.destination = destination;
        this.travelDate = travelDate;
        this.status = "PENDING";
    }

    public LocalDate getTravelDate(){
        return travelDate;
    }
    public void setTravelDate(LocalDate travelDate){
        this.travelDate = travelDate;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
