package com.Hiroo.talentSourcing.controller;


import com.Hiroo.talentSourcing.dto.AddCandidateRequestDTO;
import com.Hiroo.talentSourcing.model.Candidate;
import com.Hiroo.talentSourcing.service.CandidateService;
import com.Hiroo.talentSourcing.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/candidates")
public class CandidateController {
    private final CandidateService candidateService;
    @PostMapping("/add")
    public ApiResponse<Candidate> newCandidate(@Valid @RequestBody AddCandidateRequestDTO addCandidateRequestDTO) {
        return new ApiResponse<>(candidateService.addCandidate(addCandidateRequestDTO));
    }
}
