package com.Hiroo.talentSourcing.service;

import com.Hiroo.talentSourcing.dto.AddInteractionRequestDTO;
import com.Hiroo.talentSourcing.model.Interaction;

import java.util.List;

public interface InteractionService {
    Interaction addInteraction(AddInteractionRequestDTO requestDTO);

    Interaction editInteraction(Long id, AddInteractionRequestDTO requestDTO);

    String deleteInteraction(Long id);

    List<Interaction> getInteractions();
}
