package com.workshop.lagitech.repositories;

import com.workshop.lagitech.models.Babyfoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BabyfootRepository extends JpaRepository<Babyfoot, Long> {
    Optional<Babyfoot> findById(Long id);
}
