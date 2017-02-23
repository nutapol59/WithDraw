package com.ss.domain;

import java.io.Serializable;
import java.util.Objects;

public class ApproveMapFlow implements Serializable {

    public ApproveMapFlow() {

    }
    
    private Long id;

    private Long version;

    private AppUser employee;

    private AppUser apv1Emp;

    private AppUser accountEmp;

    private AppUser apv2Emp;

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

    public AppUser getEmployee() {
        return employee;
    }

    public void setEmployee(AppUser employee) {
        this.employee = employee;
    }

    public AppUser getApv1Emp() {
        return apv1Emp;
    }

    public void setApv1Emp(AppUser apv1Emp) {
        this.apv1Emp = apv1Emp;
    }

    public AppUser getAccountEmp() {
        return accountEmp;
    }

    public void setAccountEmp(AppUser accountEmp) {
        this.accountEmp = accountEmp;
    }

    public AppUser getApv2Emp() {
        return apv2Emp;
    }

    public void setApv2Emp(AppUser apv2Emp) {
        this.apv2Emp = apv2Emp;
    }



    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     ApproveMapFlow that = (ApproveMapFlow) o;
    //     return Objects.equals(id, that.id) &&
    //             Objects.equals(version, that.version) &&
    //             Objects.equals(employee, that.employee) &&
    //             Objects.equals(apv1Emp, that.apv1Emp) &&
    //             Objects.equals(accountEmp, that.accountEmp) &&
    //             Objects.equals(apv2Emp, that.apv2Emp);
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(id, version, employee, apv1Emp, accountEmp, apv2Emp);
    // }

    // @Override
    // public String toString() {
    //     final StringBuffer sb = new StringBuffer("ApproveMapFlow{");
    //     sb.append("id=").append(id);
    //     sb.append(", version=").append(version);
    //     sb.append(", employee=").append(employee);
    //     sb.append(", apv1Emp=").append(apv1Emp);
    //     sb.append(", accountEmp=").append(accountEmp);
    //     sb.append(", apv2Emp=").append(apv2Emp);
    //     sb.append('}');
    //     return sb.toString();
    // }
}
