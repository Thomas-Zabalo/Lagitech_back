package com.workshop.employee_api.services;

import com.workshop.employee_api.models.Team;
import com.workshop.employee_api.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamByName(String name) {
        return teamRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Team not found"));
    }

    public Team createTeam(String name) {
        Team team = new Team();
        team.setName(name);
        return teamRepository.save(team);
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team introuvable"));
    }
}
