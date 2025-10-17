package com.workshop.lagitech.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer score_1;
    private Integer score_2;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_equipe_1")
    private Team equipe_1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_equipe_2")
    private Team equipe_2;

    private Integer vitesse_max;

    @ManyToOne
    @JoinColumn(name = "babyfoot_id")
    private Babyfoot babyfoot;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime created_at = LocalDateTime.now();

    @OneToMany(mappedBy = "match", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Goal> goals;
}