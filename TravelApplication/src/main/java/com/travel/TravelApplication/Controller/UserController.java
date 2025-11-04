package com.travel.TravelApplication.Controller;

import com.travel.TravelApplication.Model.User;
import com.travel.TravelApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


   @PostMapping("/add")
    public User add(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/getAll")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @GetMapping("/getById/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
