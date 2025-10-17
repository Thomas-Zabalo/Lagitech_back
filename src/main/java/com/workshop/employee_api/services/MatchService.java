package com.workshop.employee_api.services;

import com.workshop.employee_api.models.Match;
import com.workshop.employee_api.models.Team;
import com.workshop.employee_api.repositories.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found"));
    }

    public Match createMatch(Team name1, Team name2) {
        Match match = new Match();
        match.setEquipe_1(name1);
        match.setEquipe_2(name2);
        return matchRepository.save(match);
    }
}
