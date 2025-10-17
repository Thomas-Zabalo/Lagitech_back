package com.workshop.lagitech.controllers;

import com.workshop.lagitech.services.BabyfootService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.workshop.lagitech.models.Babyfoot;

@RestController
@RequestMapping("/api/babyfoots")
@CrossOrigin(origins = "http://localhost:3000")
public class BabyfootController {

    private final BabyfootService babyfootService;

    public BabyfootController(BabyfootService babyfootService) {
        this.babyfootService = babyfootService;
    }

    @GetMapping("/all")
    public List<Babyfoot> getAllBabyfoots() {
        return babyfootService.getAllBabyfoots();
    }

    @PostMapping
    public Babyfoot addBabyfoot(@RequestBody Babyfoot babyfoot) {
        return babyfootService.addBabyfoot(babyfoot);
    }

    @PutMapping("/{id}")
    public Babyfoot updateBabyfoot(@PathVariable Long id, @RequestBody Babyfoot babyfoot) {
        return babyfootService.updateBabyfoot(id, babyfoot)
                .orElseThrow(() -> new RuntimeException("Babyfoot introuvable"));
    }

    @DeleteMapping("/{id}")
    public void deleteBabyfoot(@PathVariable Long id) {
        if (!babyfootService.deleteBabyfoot(id)) {
            throw new RuntimeException("Babyfoot introuvable");
        }
    }
}

