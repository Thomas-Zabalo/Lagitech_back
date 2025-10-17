package com.workshop.employee_api.services;

import com.workshop.employee_api.models.Goal;
import com.workshop.employee_api.models.Match;
import com.workshop.employee_api.models.Team;
import com.workshop.employee_api.repositories.GoalRepository;
import com.workshop.employee_api.repositories.MatchRepository;
import com.workshop.employee_api.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepository goalRepository;
    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public GoalService(GoalRepository goalRepository, TeamRepository teamRepository, MatchRepository matchRepository) {
        this.goalRepository = goalRepository;
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    public Goal createGoal(float vitesse, Long teamId, Long matchId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found"));

        Goal goal = new Goal();
        goal.setVitesse(vitesse);
        goal.setTeam(team);
        goal.setMatch(match);

        return goalRepository.save(goal);
    }
}
