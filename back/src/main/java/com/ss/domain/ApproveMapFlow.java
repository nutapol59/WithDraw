package com.ss.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
public class ApproveMapFlow implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version
    @JsonIgnore
    private Long version;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee")
    private AppUser employee;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apv1Emp")
    private AppUser apv1Emp;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountEmp")
    private AppUser accountEmp;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apv2Emp")
    private AppUser apv2Emp;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApproveMapFlow that = (ApproveMapFlow) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(version, that.version) &&
                Objects.equals(employee, that.employee) &&
                Objects.equals(apv1Emp, that.apv1Emp) &&
                Objects.equals(accountEmp, that.accountEmp) &&
                Objects.equals(apv2Emp, that.apv2Emp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, employee, apv1Emp, accountEmp, apv2Emp);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ApproveMapFlow{");
        sb.append("id=").append(id);
        sb.append(", version=").append(version);
        sb.append(", employee=").append(employee);
        sb.append(", apv1Emp=").append(apv1Emp);
        sb.append(", accountEmp=").append(accountEmp);
        sb.append(", apv2Emp=").append(apv2Emp);
        sb.append('}');
        return sb.toString();
    }
}
