package com.Hiroo.talentSourcing.service.impl;

import com.Hiroo.talentSourcing.dto.AddInteractionRequestDTO;
import com.Hiroo.talentSourcing.exception.CandidateNotFoundException;
import com.Hiroo.talentSourcing.exception.InteractionNotFoundException;
import com.Hiroo.talentSourcing.model.Candidate;
import com.Hiroo.talentSourcing.model.Interaction;
import com.Hiroo.talentSourcing.repository.CandidateRepository;
import com.Hiroo.talentSourcing.repository.InteractionRepository;
import com.Hiroo.talentSourcing.service.InteractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InteractionServiceImpl implements InteractionService {
    private final CandidateRepository candidateRepository;
    private final InteractionRepository interactionRepository;
    @Override
    @Transactional
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

    @Override
    @Transactional
    public Interaction editInteraction(Long id, AddInteractionRequestDTO requestDTO) {
        Interaction interaction = interactionRepository.findById(id).orElseThrow(InteractionNotFoundException::new);
        interaction.setUpdateDate(LocalDateTime.now());
        interaction.setDate(requestDTO.getDate());
        interaction.setType(requestDTO.getType());
        interaction.setContent(requestDTO.getContent());
        interaction.setCandidateResponded(requestDTO.isCandidateResponded());
        return interactionRepository.save(interaction);
    }

    @Override
    @Transactional
    public String deleteInteraction(Long id) {
        Interaction interaction = interactionRepository.findById(id).orElseThrow(InteractionNotFoundException::new);
        interactionRepository.delete(interaction);
        return "Interaction deleted successfully";
    }

    @Override
    @Transactional
    public List<Interaction> getInteractions() {
        return (List<Interaction>) interactionRepository.findAll();
    }
}
