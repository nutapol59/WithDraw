package com.ss.domain;

public class DocumentApprove {

    public DocumentApprove() {

    }


    private Long id;

    private Long version;

    private AppUser approver;

    private Integer sequence;

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

    public AppUser getApprover() {
        return approver;
    }

    public void setApprover(AppUser approver) {
        this.approver = approver;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public TravelExpense getTravelExpense() {
        return travelExpense;
    }

    public void setTravelExpense(TravelExpense travelExpense) {
        this.travelExpense = travelExpense;
    }
}
