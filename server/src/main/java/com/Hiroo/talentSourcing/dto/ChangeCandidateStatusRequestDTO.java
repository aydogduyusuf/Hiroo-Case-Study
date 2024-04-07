package com.Hiroo.talentSourcing.dto;


import com.Hiroo.talentSourcing.model.CandidateStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeCandidateStatusRequestDTO {
    private CandidateStatus candidateStatus;
}
