package com.travel.TravelApplication.Controller;

import com.travel.TravelApplication.DTOs.UserDTO;
import com.travel.TravelApplication.Model.User;
import com.travel.TravelApplication.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService service;
    public UserController(UserService service) { this.service = service; }

    @GetMapping
    public List<User> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public User create(@RequestBody UserDTO dto) {
        User user = new User(dto.getName(), dto.getEmail(), dto.getPhone());
        return service.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User u) { return service.update(id, u); }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) { service.delete(id); return "Deleted"; }
}
