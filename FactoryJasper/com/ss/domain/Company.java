package com.ss.domain;

import com.ss.base.BaseEntity;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;


public class Company extends BaseEntity implements Serializable{
    
    public Company() {

    }

  
    private Set<Department> departments;

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }



    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     if (!super.equals(o)) return false;
    //     Company company = (Company) o;
    //     return Objects.equals(departments, company.departments);
    // }


    // @Override
    // public String toString() {
    //     final StringBuffer sb = new StringBuffer("\nCompany{");
    //     sb.append("id: ");sb.append(this.getId());sb.append(", ");
    //     sb.append("version: ");sb.append(this.getVersion());sb.append(", ");
    //     sb.append("code: ");sb.append(this.getCode());sb.append(", ");
    //     sb.append("name: ");sb.append(this.getName());sb.append(", ");
    //     sb.append("active: ");sb.append(this.getActive());sb.append(",\n");
    //     if (!departments.isEmpty()){
    //         for(Department department:departments){
    //             sb.append("\tDepartment:[");
    //             sb.append("id: ");sb.append(department.getId());sb.append(", ");
    //             sb.append("version: "); sb.append(department.getVersion());  sb.append(", ");
    //             sb.append("code: ");sb.append(department.getCode());sb.append(", ");
    //             sb.append("name: "); sb.append(department.getName());sb.append(", ");
    //             sb.append("active: ");sb.append(department.getActive());sb.append("]\n");

    //         }
    //     }
    //     sb.append("} \n");
    //     return sb.toString();
    // }


}
