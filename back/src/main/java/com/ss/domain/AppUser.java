package com.ss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class AppUser implements Serializable {
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("\nAppuser{");
        sb.append("id: ");sb.append(this.getId());sb.append(", ");
        sb.append("version: ");sb.append(this.getVersion());sb.append(", ");
        sb.append("empcode: ");sb.append(this.getEmpCode());sb.append(", ");
        sb.append("empname: ");sb.append(this.getEmpName());sb.append(", ");
        sb.append("emplastname: ");sb.append(this.getEmpLastName());sb.append(", ");
        sb.append("empaddress: ");sb.append(this.getEmpAddress());sb.append(", ");
        sb.append("personalid: ");sb.append(this.getPersonalId());sb.append(", ");
        sb.append("tel: ");sb.append(this.getTel());sb.append(", ");
        sb.append("email: ");sb.append(this.getEmail());sb.append(", ");
        sb.append("ldapusername: ");sb.append(this.getLdapUserName());sb.append(", ");
        sb.append("password: ");sb.append(this.getPassword());sb.append(",\n");

        if (!appUserRole.isEmpty()){
            for(AppUserRole apur:appUserRole){
                sb.append("\tAppUserRole:[");
                sb.append("id: ");sb.append(apur.getId());sb.append(", ");
                sb.append("version: "); sb.append(apur.getVersion());  sb.append(", ");
                sb.append("code: ");sb.append(apur.getCode());sb.append(", ");
                sb.append("name: "); sb.append(apur.getName());sb.append(", ");
                sb.append("active: ");sb.append(apur.getActive());sb.append("]\n");

            }
        }

        sb.append("\tDepartment: [");
        sb.append("id: ");sb.append(department.getId());sb.append(", ");
        sb.append("version: ");sb.append(department.getVersion());sb.append(", ");
        sb.append("code: ");sb.append(department.getCode());sb.append(", ");
        sb.append("name: ");sb.append(department.getName());sb.append(", ");
        sb.append("active: ");sb.append(department.getActive());sb.append("]\n");
        sb.append("} \n");

        sb.append("\tCompany: [");
        sb.append("id: ");sb.append(company.getId());sb.append(", ");
        sb.append("version: ");sb.append(company.getVersion());sb.append(", ");
        sb.append("code: ");sb.append(company.getCode());sb.append(", ");
        sb.append("name: ");sb.append(company.getName());sb.append(", ");
        sb.append("active: ");sb.append(company.getActive());sb.append("]\n");
        sb.append("} \n");
        return sb.toString();
    }
}
