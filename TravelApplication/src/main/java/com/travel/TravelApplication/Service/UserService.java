package com.travel.TravelApplication.Service;

import com.travel.TravelApplication.ExceptionHandling.ResourceNotFoundException;
import com.travel.TravelApplication.Model.User;
import com.travel.TravelApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private  UserRepository userRepository;
    public UserService(UserRepository repo) {
        this.userRepository = repo; }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
    }
    public User create(User user) {
        return userRepository.save(user);
    }
    public User update(Long id, User updated) {
        User user = findById(id);
        user.setName(updated.getName());
        user.setEmail(updated.getEmail());
        user.setPhone(updated.getPhone());
        return userRepository.save(user);
    }
    public void delete(Long id) { userRepository.deleteById(id); }
}
