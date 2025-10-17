package com.workshop.employee_api.controllers;

import com.workshop.employee_api.DTO.GoalDTO;
import com.workshop.employee_api.models.Goal;
import com.workshop.employee_api.services.GoalService;
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
