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
    private UserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }

    @GetMapping("/getAll")
    public List<User> all() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/create")
    public User create(@RequestBody UserDTO userDTO) {
        User user = new User(userDTO.getName(), userDTO.getEmail(), userDTO.getPhone());
        return userService.create(user);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id); return "Deleted";
    }
}
