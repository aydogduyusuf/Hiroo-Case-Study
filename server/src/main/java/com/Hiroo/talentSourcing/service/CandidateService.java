package com.Hiroo.talentSourcing.service;

import com.Hiroo.talentSourcing.dto.AddCandidateRequestDTO;
import com.Hiroo.talentSourcing.dto.ChangeCandidateStatusRequestDTO;
import com.Hiroo.talentSourcing.model.Candidate;

public interface CandidateService {
    Candidate addCandidate(AddCandidateRequestDTO addCandidateRequestDTO);

    Candidate changeCandidateStatus(Long id, ChangeCandidateStatusRequestDTO requestDTO);

    Candidate updateCandidate(Long id, AddCandidateRequestDTO requestDTO);

    String deleteCandidate(Long id);
}
