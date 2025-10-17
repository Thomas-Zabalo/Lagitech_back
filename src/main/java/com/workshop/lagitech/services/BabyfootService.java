package com.workshop.lagitech.services;

import com.workshop.lagitech.models.Babyfoot;
import com.workshop.lagitech.repositories.BabyfootRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BabyfootService {

    private final BabyfootRepository babyfootRepository;

    public BabyfootService(BabyfootRepository babyfootRepository) {
        this.babyfootRepository = babyfootRepository;
    }

    // Récupère tous les babyfoots
    public List<Babyfoot> getAllBabyfoots() {
        return babyfootRepository.findAll();
    }

    // Récupère un babyfoot par son ID
    public Babyfoot getBabyfootById(Long id) {
        return babyfootRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Babyfoot introuvable"));
    }

    // Ajoute un nouveau babyfoot
    public Babyfoot addBabyfoot(Babyfoot babyfoot) {
        return babyfootRepository.save(babyfoot);
    }

    // Met à jour un babyfoot existant
    public Optional<Babyfoot> updateBabyfoot(Long id, Babyfoot updated) {
        return babyfootRepository.findById(id).map(existing -> {
            existing.setEtat(updated.getEtat());
            existing.setUsed(updated.isUsed());
            return babyfootRepository.save(existing);
        });
    }

    // Supprime un babyfoot
    public boolean deleteBabyfoot(Long id) {
        if (babyfootRepository.existsById(id)) {
            babyfootRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
