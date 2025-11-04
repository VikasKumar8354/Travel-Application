package com.travel.TravelApplication.Controller;

import com.travel.TravelApplication.DTOs.UserDTO;
import com.travel.TravelApplication.Model.User;
import com.travel.TravelApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<User> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/create")
    public User create(@RequestBody UserDTO userDTO) {
        User user = new User(userDTO.getName(), userDTO.getEmail(), userDTO.getPhone());
        return service.create(user);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return service.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id); return "Deleted";
    }
}
