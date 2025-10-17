package com.workshop.lagitech.services;

import com.workshop.lagitech.models.Goal;
import com.workshop.lagitech.models.Match;
import com.workshop.lagitech.models.Team;
import com.workshop.lagitech.repositories.GoalRepository;
import com.workshop.lagitech.repositories.MatchRepository;
import com.workshop.lagitech.repositories.TeamRepository;
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
