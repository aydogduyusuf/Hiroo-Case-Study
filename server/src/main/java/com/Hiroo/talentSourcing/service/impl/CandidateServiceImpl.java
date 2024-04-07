package com.Hiroo.talentSourcing.service.impl;

import com.Hiroo.talentSourcing.dto.AddCandidateRequestDTO;
import com.Hiroo.talentSourcing.model.Candidate;
import com.Hiroo.talentSourcing.model.CandidateStatus;
import com.Hiroo.talentSourcing.repository.CandidateRepository;
import com.Hiroo.talentSourcing.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;
    @Override
    public Candidate addCandidate(AddCandidateRequestDTO addCandidateRequestDTO) {
        Candidate candidate = new Candidate();
        candidate.setNameSurname(addCandidateRequestDTO.getNameSurname());
        candidate.setContactInformation(addCandidateRequestDTO.getContactInformation());
        candidate.setCreateDate(LocalDateTime.now());
        candidate.setCandidateStatus(CandidateStatus.SOURCED);
        return candidateRepository.save(candidate);
    }
}
