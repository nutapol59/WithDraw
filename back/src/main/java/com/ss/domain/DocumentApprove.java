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



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travelExpenseDocApprove")
    private TravelExpense travelExpense;


}
