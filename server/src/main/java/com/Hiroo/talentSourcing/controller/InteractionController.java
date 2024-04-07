package com.Hiroo.talentSourcing.controller;


import com.Hiroo.talentSourcing.dto.AddInteractionRequestDTO;
import com.Hiroo.talentSourcing.model.Interaction;
import com.Hiroo.talentSourcing.service.InteractionService;
import com.Hiroo.talentSourcing.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/interactions")
public class InteractionController {
    private final InteractionService interactionService;
    @PostMapping("/new")
    public ApiResponse<Interaction> newInteraction(@Valid @RequestBody AddInteractionRequestDTO requestDTO) {
        return new ApiResponse<>(interactionService.addInteraction(requestDTO));
    }

    @PutMapping("/edit/{id}")
    public ApiResponse<Interaction> editInteraction(@PathVariable Long id, @Valid @RequestBody AddInteractionRequestDTO requestDTO) {
        return new ApiResponse<>(interactionService.editInteraction(id, requestDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> deleteInteraction(@PathVariable Long id) {
        return new ApiResponse<>(interactionService.deleteInteraction(id));
    }

    @GetMapping()
    public ApiResponse<List<Interaction>> getInteractions() {
        return new ApiResponse<>(interactionService.getInteractions());
    }
}
