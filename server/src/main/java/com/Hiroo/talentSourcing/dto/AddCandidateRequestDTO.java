package com.Hiroo.talentSourcing.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCandidateRequestDTO {
    @NotBlank(message = "Name Surname is required")
    @NotNull(message = "Name Surname is required")
    private String nameSurname;

    @NotBlank(message = "Contact Information is required")
    @NotNull(message = "Contact Information is required")
    private String contactInformation;
}
