package com.workshop.lagitech.repositories;

import com.workshop.lagitech.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    List<User> findByTeamId(Long teamId);

    Optional<User> findByEmail(String email);
}
