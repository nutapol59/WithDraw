package com.ss.domain;

import java.util.Set;
import java.io.Serializable;
public class AppUser implements Serializable {

    public AppUser() {

    }

    private Long id;

    private Long version;

    private String empCode;

    private String empName;

    private String empLastName;

    private String empAddress;

    private String personalId;

    private String tel;

    private String email;

    private String ldapUserName;

    private String password;

    private Set<AppUserRole> appUserRole;

    private Department department;

    private Company company;


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

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLdapUserName() {
        return ldapUserName;
    }

    public void setLdapUserName(String ldapUserName) {
        this.ldapUserName = ldapUserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<AppUserRole> getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(Set<AppUserRole> appUserRole) {
        this.appUserRole = appUserRole;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

//     @Override
//     public String toString() {
//         final StringBuffer sb = new StringBuffer("\nAppuser{");
//         sb.append("id: ");sb.append(this.getId());sb.append(", ");
//         sb.append("version: ");sb.append(this.getVersion());sb.append(", ");
//         sb.append("empcode: ");sb.append(this.getEmpCode());sb.append(", ");
//         sb.append("empname: ");sb.append(this.getEmpName());sb.append(", ");
//         sb.append("emplastname: ");sb.append(this.getEmpLastName());sb.append(", ");
//         sb.append("empaddress: ");sb.append(this.getEmpAddress());sb.append(", ");
//         sb.append("personalid: ");sb.append(this.getPersonalId());sb.append(", ");
//         sb.append("tel: ");sb.append(this.getTel());sb.append(", ");
//         sb.append("email: ");sb.append(this.getEmail());sb.append(", ");
//         sb.append("ldapusername: ");sb.append(this.getLdapUserName());sb.append(", ");
//         sb.append("password: ");sb.append(this.getPassword());sb.append(",\n");

// //        if (!appUserRole.isEmpty()){
// //            for(AppUserRole apur:appUserRole){
// //                sb.append("\tAppUserRole:[");
// //                sb.append("id: ");sb.append(apur.getId());sb.append(", ");
// //                sb.append("version: "); sb.append(apur.getVersion());  sb.append(", ");
// //                sb.append("code: ");sb.append(apur.getCode());sb.append(", ");
// //                sb.append("name: "); sb.append(apur.getName());sb.append(", ");
// //                sb.append("active: ");sb.append(apur.getActive());sb.append("]\n");
// //
// //            }
// //        }

//         sb.append("\tDepartment: [");
//         sb.append("id: ");sb.append(department.getId());sb.append(", ");
//         sb.append("version: ");sb.append(department.getVersion());sb.append(", ");
//         sb.append("code: ");sb.append(department.getCode());sb.append(", ");
//         sb.append("name: ");sb.append(department.getName());sb.append(", ");
//         sb.append("active: ");sb.append(department.getActive());sb.append("]\n");
//         sb.append("} \n");

//         sb.append("\tCompany: [");
//         sb.append("id: ");sb.append(company.getId());sb.append(", ");
//         sb.append("version: ");sb.append(company.getVersion());sb.append(", ");
//         sb.append("code: ");sb.append(company.getCode());sb.append(", ");
//         sb.append("name: ");sb.append(company.getName());sb.append(", ");
//         sb.append("active: ");sb.append(company.getActive());sb.append("]\n");
//         sb.append("} \n");
//         return sb.toString();
//     }
}
