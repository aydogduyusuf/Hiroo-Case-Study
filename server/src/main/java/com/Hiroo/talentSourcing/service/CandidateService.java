package com.Hiroo.talentSourcing.service;

import com.Hiroo.talentSourcing.dto.AddCandidateRequestDTO;
import com.Hiroo.talentSourcing.model.Candidate;

public interface CandidateService {
    Candidate addCandidate(AddCandidateRequestDTO addCandidateRequestDTO);
}
