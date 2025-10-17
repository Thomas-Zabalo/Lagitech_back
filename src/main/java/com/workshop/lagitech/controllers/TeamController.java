package com.workshop.lagitech.controllers;

import com.workshop.lagitech.models.Team;
import com.workshop.lagitech.services.TeamService;
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
