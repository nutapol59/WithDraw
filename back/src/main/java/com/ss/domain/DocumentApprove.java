package com.ss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DocumentApprove {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version
    @JsonIgnore
    private Long version;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approver")
    private AppUser approver;

    @Column
    private Integer sequence;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approveMapFlow")
    private ApproveMapFlow approveMapFlow;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travelExpense")
    private TravelExpense travelExpense;
}
