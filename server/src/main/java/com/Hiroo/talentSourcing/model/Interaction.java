package com.Hiroo.talentSourcing.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="interactions")
@Getter
@Setter
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @Column(name = "interaction_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private InteractionType type;

    @Column(name = "interaction_content", nullable = false)
    private String content;

    @Column(name = "interaction_date", nullable = false)
    private LocalDateTime date;

    @Column(name = "candidate_responded", nullable = false)
    private boolean candidateResponded;
}
