package com.workshop.employee_api.controllers;

import com.workshop.employee_api.models.Team;
import com.workshop.employee_api.services.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin(origins = "http://localhost:3000") // pour autoriser ton frontend
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/name")
    public Team getTeamByName(@RequestParam String name) {
        return teamService.getTeamByName(name);
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team.getName());
    }
}
