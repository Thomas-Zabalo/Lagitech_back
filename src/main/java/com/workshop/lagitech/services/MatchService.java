package com.workshop.lagitech.services;

import com.workshop.lagitech.models.Match;
import com.workshop.lagitech.models.Team;
import com.workshop.lagitech.repositories.MatchRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Match startMatch(@RequestBody Long id) {
        Match oldMatch = getMatchById(id);
        oldMatch.setScore_1(0);
        oldMatch.setScore_2(0);
        return matchRepository.save(oldMatch);
    }

    public Match createMatch(Team name1, Team name2) {
        Match match = new Match();
        match.setEquipe_1(name1);
        match.setEquipe_2(name2);
        return matchRepository.save(match);
    }
}
