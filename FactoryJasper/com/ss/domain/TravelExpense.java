package com.ss.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class TravelExpense extends DocumentMaster implements Serializable{

    public TravelExpense() {

    }

    private Date expenseDate;

    private AppUser employee;

    private Company company;

    private Department department;

    private String comment;

    private  Date approvelDate;

    private Date payDate;

    private Integer cash;

    private String chequeNumber;

    private Bank chequeBank;

    private BigDecimal expenseSummary;

    private Set<TravelExpenseDetail> travelExpenseDetails;

    private Set<DocumentApprove> documentApproves;

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public AppUser getEmployee() {
        return employee;
    }

    public void setEmployee(AppUser employee) {
        this.employee = employee;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getApprovelDate() {
        return approvelDate;
    }

    public void setApprovelDate(Date approvelDate) {
        this.approvelDate = approvelDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public String getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public Bank getChequeBank() {
        return chequeBank;
    }

    public void setChequeBank(Bank chequeBank) {
        this.chequeBank = chequeBank;
    }

    public BigDecimal getExpenseSummary() {
        return expenseSummary;
    }

    public void setExpenseSummary(BigDecimal expenseSummary) {
        this.expenseSummary = expenseSummary;
    }

    public Set<TravelExpenseDetail> getTravelExpenseDetails() {
        return travelExpenseDetails;
    }

    public void setTravelExpenseDetails(Set<TravelExpenseDetail> travelExpenseDetails) {
        this.travelExpenseDetails = travelExpenseDetails;
    }

    public Set<DocumentApprove> getDocumentApproves() {
        return documentApproves;
    }

    public void setDocumentApproves(Set<DocumentApprove> documentApproves) {
        this.documentApproves = documentApproves;
    }


//     @Override
//     public boolean equals(Object o) {
//         if (this == o) return true;
//         if (o == null || getClass() != o.getClass()) return false;
//         if (!super.equals(o)) return false;
//         TravelExpense that = (TravelExpense) o;
//         return Objects.equals(expenseDate, that.expenseDate) &&
//                 Objects.equals(employee, that.employee) &&
//                 Objects.equals(company, that.company) &&
//                 Objects.equals(department, that.department) &&
//                 Objects.equals(comment, that.comment) &&
//                 Objects.equals(approvelDate, that.approvelDate) &&
//                 Objects.equals(payDate, that.payDate) &&
//                 Objects.equals(cash, that.cash) &&
//                 Objects.equals(chequeNumber, that.chequeNumber) &&
//                 Objects.equals(chequeBank, that.chequeBank) &&
//                 Objects.equals(expenseSummary, that.expenseSummary) &&
//                 Objects.equals(travelExpenseDetails, that.travelExpenseDetails) &&
//                 Objects.equals(documentApproves, that.documentApproves);
//     }

//     @Override
//     public String toString() {
//         final StringBuffer sb = new StringBuffer("TravelExpense{");
//         sb.append("expenseDate=").append(expenseDate);
//         sb.append(", employee=").append(employee);
//         sb.append(", company=").append(company);
//         sb.append(", department=").append(department);
//         sb.append(", comment='").append(comment).append('\'');
//         sb.append(", approvelDate=").append(approvelDate);
//         sb.append(", payDate=").append(payDate);
//         sb.append(", cash=").append(cash);
// //        if(cash == 1){
//             sb.append(", chequeNumber='").append(chequeNumber).append('\'');
//             sb.append(", chequeBank=").append(chequeBank.getId());
// //        }
//         sb.append(", expenseSummary=").append(expenseSummary);
//         sb.append(", travelExpenseDetails=").append(travelExpenseDetails);
//         sb.append(", documentApproves=").append(documentApproves);
//         sb.append('}');
//         return sb.toString();
//     }
}

