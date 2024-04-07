package com.Hiroo.talentSourcing.service.impl;

import com.Hiroo.talentSourcing.dto.AddInteractionRequestDTO;
import com.Hiroo.talentSourcing.exception.CandidateNotFoundException;
import com.Hiroo.talentSourcing.model.Candidate;
import com.Hiroo.talentSourcing.model.Interaction;
import com.Hiroo.talentSourcing.repository.CandidateRepository;
import com.Hiroo.talentSourcing.repository.InteractionRepository;
import com.Hiroo.talentSourcing.service.InteractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class InteractionServiceImpl implements InteractionService {
    private final CandidateRepository candidateRepository;
    private final InteractionRepository interactionRepository;
    @Override
    public Interaction addInteraction(AddInteractionRequestDTO requestDTO) {
        Interaction interaction = new Interaction();
        Candidate candidate = candidateRepository.findById(requestDTO.getCandidateId()).orElseThrow(CandidateNotFoundException::new);
        interaction.setCandidate(candidate);
        interaction.setDate(requestDTO.getDate());
        interaction.setType(requestDTO.getType());
        interaction.setContent(requestDTO.getContent());
        interaction.setCandidateResponded(requestDTO.isCandidateResponded());
        interaction.setCreateDate(LocalDateTime.now());
        return interactionRepository.save(interaction);
    }
}
