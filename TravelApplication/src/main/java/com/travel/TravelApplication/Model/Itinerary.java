package com.travel.TravelApplication.Model;

import jakarta.persistence.*;

@Entity
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dayTitle;
    @Column(length = 2000)
    private String activity;
    private String place;

    @ManyToOne
    private TourPackage tourPackage;

    public Itinerary(){}

    public Itinerary(Long id, String dayTitle, String activity, String place, TourPackage tourPackage) {
        this.id = id;
        this.dayTitle = dayTitle;
        this.activity = activity;
        this.place = place;
        this.tourPackage = tourPackage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDayTitle() {
        return dayTitle;
    }

    public void setDayTitle(String dayTitle) {
        this.dayTitle = dayTitle;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }
}
