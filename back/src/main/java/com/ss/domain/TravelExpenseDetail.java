package com.ss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
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
    @DateTimeFormat(pattern = "yyyy-mm-dd")
//    HH:mm:ss.SSS
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelExpenseDetail that = (TravelExpenseDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(version, that.version) &&
                Objects.equals(travelDate, that.travelDate) &&
                Objects.equals(customer, that.customer) &&
                Objects.equals(travelFrom, that.travelFrom) &&
                Objects.equals(travelTo, that.travelTo) &&
                Objects.equals(expense, that.expense) &&
                Objects.equals(expWayExpense, that.expWayExpense) &&
                Objects.equals(expenseSubSummary, that.expenseSubSummary) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(attachFile1, that.attachFile1) &&
                Objects.equals(attachFile2, that.attachFile2) &&
                Objects.equals(attachFile3, that.attachFile3) &&
                Objects.equals(travelExpense, that.travelExpense);
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TravelExpenseDetail{");
        sb.append("id=").append(id);
        sb.append(", version=").append(version);
        sb.append(", travelDate=").append(travelDate);
        sb.append(", customer=").append(customer.getId());
        sb.append(", travelFrom='").append(travelFrom).append('\'');
        sb.append(", travelTo='").append(travelTo).append('\'');
        sb.append(", expense=").append(expense);
        sb.append(", expWayExpense=").append(expWayExpense);
        sb.append(", expenseSubSummary=").append(expenseSubSummary);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", attachFile1='").append(attachFile1).append('\'');
        sb.append(", attachFile2='").append(attachFile2).append('\'');
        sb.append(", attachFile3='").append(attachFile3).append('\'');
        sb.append(", travelExpense=").append(travelExpense.getId());
        sb.append('}');
        return sb.toString();
    }
}
