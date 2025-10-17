package com.workshop.lagitech.controllers;

import com.workshop.lagitech.models.Match;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MatchWebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    public MatchWebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendMatchUpdate(Match match) {
        messagingTemplate.convertAndSend("/topic/matches", match);
    }
}
