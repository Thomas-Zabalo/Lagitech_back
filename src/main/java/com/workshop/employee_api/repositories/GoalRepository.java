package com.workshop.employee_api.repositories;

import com.workshop.employee_api.models.Goal;
import com.workshop.employee_api.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    Optional<Goal> findById(Long id);
}
