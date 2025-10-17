package com.workshop.employee_api.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "goal")
public class Goal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_id")
    @JsonIgnoreProperties("goals")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnoreProperties({"users"})
    private Team team;

    private float vitesse;
}