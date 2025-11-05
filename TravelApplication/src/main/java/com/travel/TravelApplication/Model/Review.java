package com.travel.TravelApplication.Model;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    // ✅ Default constructor
    public Review() {}

    // ✅ Constructor used in your code
    public Review(int rating, String comment, Destination destination, User user) {
        this.rating = rating;
        this.comment = comment;
        this.destination = destination;
        this.user = user;
    }

    // ✅ Optional: full constructor with id (used for testing or manual setups)
    public Review(Long id, int rating, String comment, Destination destination, User user) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.destination = destination;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
