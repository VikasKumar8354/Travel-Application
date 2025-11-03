package com.travel.TravelApplication.Service;

import com.travel.TravelApplication.ExceptionHandling.ResourceNotFoundException;
import com.travel.TravelApplication.Model.User;
import com.travel.TravelApplication.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
