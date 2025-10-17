package com.workshop.lagitech.services;

import com.workshop.lagitech.models.Goal;
import com.workshop.lagitech.models.Match;
import com.workshop.lagitech.models.Team;
import com.workshop.lagitech.repositories.GoalRepository;
import com.workshop.lagitech.repositories.MatchRepository;
import com.workshop.lagitech.repositories.TeamRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GoalService {

    private final GoalRepository goalRepository;
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final SimpMessagingTemplate messagingTemplate;

    public GoalService(
            GoalRepository goalRepository,
            MatchRepository matchRepository,
            TeamRepository teamRepository,
            SimpMessagingTemplate messagingTemplate) {
        this.goalRepository = goalRepository;
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.messagingTemplate = messagingTemplate;
    }

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    @Transactional
    public Goal createGoal(float vitesse, Long teamId, Long matchId) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match non trouvé avec l'ID: " + matchId));

        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Équipe non trouvée avec l'ID: " + teamId));

        Goal goal = new Goal();
        goal.setVitesse(vitesse);
        goal.setTeam(team);
        goal.setMatch(match);
        goal = goalRepository.save(goal);

        // 4. Mettre à jour le score du match
        if (match.getEquipe_1().getId().equals(teamId)) {
            Integer currentScore = match.getScore_1() != null ? match.getScore_1() : 0;
            match.setScore_1(currentScore + 1);

        } else if (match.getEquipe_2().getId().equals(teamId)) {
            Integer currentScore = match.getScore_2() != null ? match.getScore_2() : 0;
            match.setScore_2(currentScore + 1);
        } else {
            throw new RuntimeException("L'équipe n'appartient pas à ce match");
        }

        Float currentMaxSpeed = match.getVitesse_max() != null ? match.getVitesse_max() : 0f;
        if (vitesse > currentMaxSpeed) {
            match.setVitesse_max(vitesse);
            System.out.println("⚡ Nouvelle vitesse max: " + vitesse + " km/h");
        }

        match = matchRepository.save(match);

        messagingTemplate.convertAndSend("/topic/matches", match);
        messagingTemplate.convertAndSend("/topic/matches/" + matchId, match);

        return goal;
    }
}