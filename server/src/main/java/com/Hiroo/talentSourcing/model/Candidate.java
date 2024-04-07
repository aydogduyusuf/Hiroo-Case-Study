package com.Hiroo.talentSourcing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="candidates")
@Getter
@Setter
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_surname", nullable = false)
    private String nameSurname;

    @Column(name = "contact_information", nullable = false)
    private String contactInformation;

    @OneToMany(mappedBy = "candidate", orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("candidate")
    private List<Interaction> interactions;

    @Column(name = "candidate_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private CandidateStatus candidateStatus;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updateDate;
}
