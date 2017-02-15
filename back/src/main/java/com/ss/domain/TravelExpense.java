package com.ss.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor

public class TravelExpense extends DocumentMaster implements Serializable{
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
//    HH:mm:ss.SSS
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
    @DateTimeFormat(pattern = "yyyy-mm-dd")
//    HH:mm:ss.SSS
    @Column
    private  Date approvelDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
//    HH:mm:ss.SSS"
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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "travelExpenseDocApprove")
    private Set<DocumentApprove> documentApproves;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TravelExpense that = (TravelExpense) o;
        return Objects.equals(expenseDate, that.expenseDate) &&
                Objects.equals(employee, that.employee) &&
                Objects.equals(company, that.company) &&
                Objects.equals(department, that.department) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(approvelDate, that.approvelDate) &&
                Objects.equals(payDate, that.payDate) &&
                Objects.equals(cash, that.cash) &&
                Objects.equals(chequeNumber, that.chequeNumber) &&
                Objects.equals(chequeBank, that.chequeBank) &&
                Objects.equals(expenseSummary, that.expenseSummary) &&
                Objects.equals(travelExpenseDetails, that.travelExpenseDetails) &&
                Objects.equals(documentApproves, that.documentApproves);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TravelExpense{");
        sb.append("expenseDate=").append(expenseDate);
        sb.append(", employee=").append(employee);
        sb.append(", company=").append(company);
        sb.append(", department=").append(department);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", approvelDate=").append(approvelDate);
        sb.append(", payDate=").append(payDate);
        sb.append(", cash=").append(cash);
//        if(cash == 1){
            sb.append(", chequeNumber='").append(chequeNumber).append('\'');
            sb.append(", chequeBank=").append(chequeBank.getId());
//        }
        sb.append(", expenseSummary=").append(expenseSummary);
        sb.append(", travelExpenseDetails=").append(travelExpenseDetails);
        sb.append(", documentApproves=").append(documentApproves);
        sb.append('}');
        return sb.toString();
    }
}

