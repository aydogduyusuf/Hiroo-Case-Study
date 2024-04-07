package com.Hiroo.talentSourcing.controller;


import com.Hiroo.talentSourcing.dto.AddInteractionRequestDTO;
import com.Hiroo.talentSourcing.model.Interaction;
import com.Hiroo.talentSourcing.service.InteractionService;
import com.Hiroo.talentSourcing.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/interactions")
public class InteractionController {
    private final InteractionService interactionService;
    @PostMapping("/new")
    public ApiResponse<Interaction> newInteraction(@Valid @RequestBody AddInteractionRequestDTO requestDTO) {
        return new ApiResponse<>(interactionService.addInteraction(requestDTO));
    }
}
