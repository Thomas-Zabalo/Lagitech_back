package com.workshop.lagitech.controllers;

import com.workshop.lagitech.models.User;
import com.workshop.lagitech.repositories.UserRepository;
import com.workshop.lagitech.services.JwtService;
import com.workshop.lagitech.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    private final UserService userService;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          JwtService jwtService,
                          AuthenticationManager authManager, UserService userService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authManager = authManager;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
        if (userRepository.findByName(user.getName()).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Utilisateur déjà existant"));
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAdmin(false);
        userRepository.save(user);

        String token = jwtService.generateToken(user.getName());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("username", user.getName());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        try {
            System.out.println("Tentative de login pour : " + request.email());
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.email(), request.password())
            );

            System.out.println("Authentifié : " + auth.getName());

            // Génération du token JWT
            String token = jwtService.generateToken(auth.getName());

            User user = userService.findByEmail(request.email());

            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("user_id", user.getId());
            response.put("username", user.getName());
            response.put("email", user.getEmail());
            response.put("team_id", user.getTeam());
            response.put("is_admin", user.isAdmin());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Identifiants incorrects"));
        }
    }


    record LoginRequest(String email, String password) {}
}