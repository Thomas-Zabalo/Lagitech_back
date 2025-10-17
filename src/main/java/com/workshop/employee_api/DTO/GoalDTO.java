package com.workshop.employee_api.DTO;

public class GoalDTO {
    private float vitesse;
    private Long teamId;
    private Long matchId;

    // Getters et setters
    public float getVitesse() { return vitesse; }
    public void setVitesse(float vitesse) { this.vitesse = vitesse; }

    public Long getTeamId() { return teamId; }
    public void setTeamId(Long teamId) { this.teamId = teamId; }

    public Long getMatchId() { return matchId; }
    public void setMatchId(Long matchId) { this.matchId = matchId; }
}
