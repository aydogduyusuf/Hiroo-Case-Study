package com.Hiroo.talentSourcing.service;

import com.Hiroo.talentSourcing.dto.AddInteractionRequestDTO;
import com.Hiroo.talentSourcing.model.Interaction;

public interface InteractionService {
    Interaction addInteraction(AddInteractionRequestDTO requestDTO);
}
