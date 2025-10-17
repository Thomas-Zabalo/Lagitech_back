package com.workshop.lagitech.controllers;

import com.workshop.lagitech.models.Match;
import com.workshop.lagitech.models.Team;
import com.workshop.lagitech.services.MatchService;
import com.workshop.lagitech.services.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/matches")
@CrossOrigin(origins = "http://localhost:3000")
public class MatchController {

    private final MatchService matchService;
    private final TeamService teamService;

    public MatchController(MatchService matchService, TeamService teamService) {
        this.matchService = matchService;
        this.teamService = teamService;
    }

    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/{id}")
    public Match getMatchByName(@PathVariable Long id) {
        return matchService.getMatchById(id);
    }

    @PostMapping
    public Match createMatch(@RequestBody Map<String, Long> request) {
        Long team1Id = request.get("equipe_1");
        Long team2Id = request.get("equipe_2");

        Team team1 = teamService.getTeamById(team1Id);
        Team team2 = teamService.getTeamById(team2Id);

        return matchService.createMatch(team1, team2);
    }

}
