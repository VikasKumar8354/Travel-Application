package com.travel.TravelApplication.Repository;

import com.travel.TravelApplication.Model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination,Long> {
}
