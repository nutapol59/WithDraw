package com.ss.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ApproveMapFlow {
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


}
