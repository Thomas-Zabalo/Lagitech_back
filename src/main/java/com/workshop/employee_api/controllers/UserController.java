package com.workshop.employee_api.controllers;

import com.workshop.employee_api.models.User;
import com.workshop.employee_api.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/team/{teamId}")
    public List<User> getUsersByTeam(@PathVariable Long teamId) {
        return userService.getUsersByTeam(teamId);
    }
    @GetMapping("/email")
    public Optional<User> getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }
}
