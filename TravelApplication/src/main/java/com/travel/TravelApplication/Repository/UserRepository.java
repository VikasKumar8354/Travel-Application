package com.travel.TravelApplication.Repository;

import com.travel.TravelApplication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
