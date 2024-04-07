package com.Hiroo.talentSourcing.dto;


import com.Hiroo.talentSourcing.model.InteractionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddInteractionRequestDTO {
    private Long candidateId;
    private InteractionType type;
    private String content;
    private LocalDateTime date;
    private boolean candidateResponded;
}
