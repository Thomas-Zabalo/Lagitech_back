package com.workshop.lagitech.controllers;

import com.workshop.lagitech.services.BabyfootService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/babyfoots")
@CrossOrigin(origins = "http://localhost:3000")
public class BabyfootController {

    private final BabyfootService babyfootService;
    public BabyfootController(BabyfootService babyfootService) {
        this.babyfootService = babyfootService;
    }

//    @GetMapping
//    public List<Babyfoot> getAllBabyfoots() {
//        return babyfootService.getAllBabyfoots();
//    }
//
//    @GetMapping("/available")
//    public List<Babyfoot> getAvailableBabyfoots() {
//        return babyfootService.getAvailableBabyfoots();
//    }
}
