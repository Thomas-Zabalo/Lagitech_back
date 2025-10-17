package com.workshop.lagitech.controllers;

import com.workshop.lagitech.DTO.GoalDTO;
import com.workshop.lagitech.models.Goal;
import com.workshop.lagitech.services.GoalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
@CrossOrigin(origins = "http://localhost:3000")
public class GoalController {

    private final GoalService goalService;
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping
    public List<Goal> getAllGoals() {
        return goalService.getAllGoals();
    }

    @PostMapping
    public Goal createGoal(@RequestBody GoalDTO goalDTO) {
        return goalService.createGoal(goalDTO.getVitesse(), goalDTO.getTeamId(), goalDTO.getMatchId());
    }
}
