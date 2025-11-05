package com.travel.TravelApplication.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity

public class TourPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double price;
    private int durationDays;
    @Column(length = 2000)
    private String description;

    @OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Itinerary> itineraries;

    public TourPackage(){}

    public TourPackage(Long id, String title, double price, int durationDays, String description, List<Itinerary> itineraries) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.durationDays = durationDays;
        this.description = description;
        this.itineraries = itineraries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    public void setItineraries(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }
}
