package com.Hiroo.talentSourcing.controller;


import com.Hiroo.talentSourcing.dto.*;
import com.Hiroo.talentSourcing.model.Candidate;
import com.Hiroo.talentSourcing.service.CandidateService;
import com.Hiroo.talentSourcing.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/candidates")
public class CandidateController {
    private final CandidateService candidateService;
    @PostMapping("/new")
    public ApiResponse<Candidate> newCandidate(@Valid @RequestBody AddCandidateRequestDTO addCandidateRequestDTO) {
        return new ApiResponse<>(candidateService.addCandidate(addCandidateRequestDTO));
    }

    @PatchMapping("/changeStatus/{id}")
    public ApiResponse<Candidate> changeStatus(@PathVariable Long id, @Valid @RequestBody ChangeCandidateStatusRequestDTO requestDTO) {
        return new ApiResponse<>(candidateService.changeCandidateStatus(id, requestDTO));
    }

    @PutMapping("/edit/{id}")
    public ApiResponse<Candidate> editCandidate(@PathVariable Long id, @Valid @RequestBody AddCandidateRequestDTO requestDTO) {
        return new ApiResponse<>(candidateService.updateCandidate(id, requestDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> editCandidate(@PathVariable Long id) {
        return new ApiResponse<>(candidateService.deleteCandidate(id));
    }

    @GetMapping("")
    public ApiResponse<List<Candidate>> getCandidates() {
        return new ApiResponse<>(candidateService.getCandidates());
    }
}
