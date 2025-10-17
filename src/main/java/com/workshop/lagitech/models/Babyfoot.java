package com.workshop.lagitech.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "babyfoot")
public class Babyfoot {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isUsed;
    private String etat;
}
