package com.workshop.lagitech.controllers;

import com.workshop.lagitech.models.User;
import com.workshop.lagitech.services.UserService;
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

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    @PutMapping("/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody User updatedUser) {
        User currentUser = userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        // Mettre à jour uniquement les champs autorisés
        currentUser.setName(updatedUser.getName());
        currentUser.setEmail(updatedUser.getEmail());

        return userService.updateUser(id,currentUser);
    }

}
