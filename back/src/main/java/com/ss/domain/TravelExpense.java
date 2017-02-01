package com.ss.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data

@AllArgsConstructor
@Entity
public class TravelExpense extends DocumentMaster{
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss.SSS")
    @Column
    private Date expenseDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appUser")
    private AppUser employee;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company")
    private Company company;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department")
    private Department department;

    @Column
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss.SSS")
    @Column
    private  Date approvelDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss.SSS")
    @Column
    private Date payDate;

    @Column
    private Integer cash;

    @Column
    private String chequeNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank")
    private Bank chequeBank;

    @Column
    private BigDecimal expenseSummary;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "travelExpense")
    private Set<TravelExpenseDetail> travelExpenseDetails;
}

