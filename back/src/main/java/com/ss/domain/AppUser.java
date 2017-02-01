package com.ss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AppUser {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version
    @JsonIgnore
    private Long version;

    @Column
    private String empCode;

    @Column
    private String empName;

    @Column
    private String empLastName;

    @Column
    private String empAddress;

    @Column
    private String personalId;

    @Column
    private String tel;

    @Column
    private String email;

    @Column
    private String ldapUserName;

    @Column
    private String password;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="appUser")
    private Set<AppUserRole> appUserRole;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department")
    private Department department;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company")
    private Company company;
}
