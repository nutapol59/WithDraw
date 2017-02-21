package com.ss.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class TravelExpenseDetail {

    public TravelExpenseDetail() {
    }


    private Long id;

    private Long version;

    private Date travelDate;

    private Customer customer;

    private String travelFrom;

    private String travelTo;

    private BigDecimal expense;

    private BigDecimal expWayExpense;

    private BigDecimal expenseSubSummary;

    private String comment;

    private String attachFile1;

    private String attachFile2;

    private String attachFile3;

    private TravelExpense travelExpense;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTravelFrom() {
        return travelFrom;
    }

    public void setTravelFrom(String travelFrom) {
        this.travelFrom = travelFrom;
    }

    public String getTravelTo() {
        return travelTo;
    }

    public void setTravelTo(String travelTo) {
        this.travelTo = travelTo;
    }

    public BigDecimal getExpense() {
        return expense;
    }

    public void setExpense(BigDecimal expense) {
        this.expense = expense;
    }

    public BigDecimal getExpWayExpense() {
        return expWayExpense;
    }

    public void setExpWayExpense(BigDecimal expWayExpense) {
        this.expWayExpense = expWayExpense;
    }

    public BigDecimal getExpenseSubSummary() {
        return expenseSubSummary;
    }

    public void setExpenseSubSummary(BigDecimal expenseSubSummary) {
        this.expenseSubSummary = expenseSubSummary;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAttachFile1() {
        return attachFile1;
    }

    public void setAttachFile1(String attachFile1) {
        this.attachFile1 = attachFile1;
    }

    public String getAttachFile2() {
        return attachFile2;
    }

    public void setAttachFile2(String attachFile2) {
        this.attachFile2 = attachFile2;
    }

    public String getAttachFile3() {
        return attachFile3;
    }

    public void setAttachFile3(String attachFile3) {
        this.attachFile3 = attachFile3;
    }

    public TravelExpense getTravelExpense() {
        return travelExpense;
    }

    public void setTravelExpense(TravelExpense travelExpense) {
        this.travelExpense = travelExpense;
    }

    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     TravelExpenseDetail that = (TravelExpenseDetail) o;
    //     return Objects.equals(id, that.id) &&
    //             Objects.equals(version, that.version) &&
    //             Objects.equals(travelDate, that.travelDate) &&
    //             Objects.equals(customer, that.customer) &&
    //             Objects.equals(travelFrom, that.travelFrom) &&
    //             Objects.equals(travelTo, that.travelTo) &&
    //             Objects.equals(expense, that.expense) &&
    //             Objects.equals(expWayExpense, that.expWayExpense) &&
    //             Objects.equals(expenseSubSummary, that.expenseSubSummary) &&
    //             Objects.equals(comment, that.comment) &&
    //             Objects.equals(attachFile1, that.attachFile1) &&
    //             Objects.equals(attachFile2, that.attachFile2) &&
    //             Objects.equals(attachFile3, that.attachFile3) &&
    //             Objects.equals(travelExpense, that.travelExpense);
    // }


    // @Override
    // public String toString() {
    //     final StringBuffer sb = new StringBuffer("TravelExpenseDetail{");
    //     sb.append("id=").append(id);
    //     sb.append(", version=").append(version);
    //     sb.append(", travelDate=").append(travelDate);
    //     sb.append(", customer=").append(customer.getId());
    //     sb.append(", travelFrom='").append(travelFrom).append('\'');
    //     sb.append(", travelTo='").append(travelTo).append('\'');
    //     sb.append(", expense=").append(expense);
    //     sb.append(", expWayExpense=").append(expWayExpense);
    //     sb.append(", expenseSubSummary=").append(expenseSubSummary);
    //     sb.append(", comment='").append(comment).append('\'');
    //     sb.append(", attachFile1='").append(attachFile1).append('\'');
    //     sb.append(", attachFile2='").append(attachFile2).append('\'');
    //     sb.append(", attachFile3='").append(attachFile3).append('\'');
    //     sb.append(", travelExpense=").append(travelExpense.getId());
    //     sb.append('}');
    //     return sb.toString();
    // }
}
