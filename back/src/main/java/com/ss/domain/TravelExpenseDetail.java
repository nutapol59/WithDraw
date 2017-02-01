package com.ss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TravelExpenseDetail {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version
    @JsonIgnore
    private Long version;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss.SSS")
    @Column
    private Date travelDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer")
    private Customer customer;

    @Column
    private String travelFrom;

    @Column
    private String travelTo;

    @Column
    private BigDecimal expense;

    @Column
    private BigDecimal expWayExpense;

    @Column
    private BigDecimal expenseSubSummary;

    @Column
    private String comment;

    @Column
    private String attachFile1;

    @Column
    private String attachFile2;

    @Column
    private String attachFile3;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travelExpense")
    private TravelExpense travelExpense;
}
