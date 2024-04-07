package com.Hiroo.talentSourcing.service.impl;

import com.Hiroo.talentSourcing.dto.AddCandidateRequestDTO;
import com.Hiroo.talentSourcing.dto.ChangeCandidateStatusRequestDTO;
import com.Hiroo.talentSourcing.exception.CandidateNotFoundException;
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

    @Override
    public Candidate changeCandidateStatus(Long id, ChangeCandidateStatusRequestDTO requestDTO) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(CandidateNotFoundException::new);
        candidate.setCandidateStatus(requestDTO.getCandidateStatus());
        candidate.setUpdateDate(LocalDateTime.now());
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate updateCandidate(Long id, AddCandidateRequestDTO requestDTO) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(CandidateNotFoundException::new);
        candidate.setUpdateDate(LocalDateTime.now());
        candidate.setContactInformation(requestDTO.getContactInformation());
        candidate.setNameSurname(requestDTO.getNameSurname());
        return candidateRepository.save(candidate);
    }

    @Override
    public String deleteCandidate(Long id) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(CandidateNotFoundException::new);
        candidateRepository.delete(candidate);
        return "Candidate deleted successfully";
    }
}
