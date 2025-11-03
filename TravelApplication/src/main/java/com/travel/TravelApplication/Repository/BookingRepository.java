package com.travel.TravelApplication.Repository;

import com.travel.TravelApplication.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
