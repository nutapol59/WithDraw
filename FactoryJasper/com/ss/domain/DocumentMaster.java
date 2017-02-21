package com.ss.domain;
import java.util.Date;

public class DocumentMaster {

    
    public DocumentMaster() {

    }

    private Long id;

    private Long version;

    private String documentNumber;

    private String documentStatus;


    private Integer approveSeq;

    private Date documentDate;

    private ApproveMapFlow approveMapFlow;

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

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public Integer getApproveSeq() {
        return approveSeq;
    }

    public void setApproveSeq(Integer approveSeq) {
        this.approveSeq = approveSeq;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public ApproveMapFlow getApproveMapFlow() {
        return approveMapFlow;
    }

    public void setApproveMapFlow(ApproveMapFlow approveMapFlow) {
        this.approveMapFlow = approveMapFlow;
    }

}
