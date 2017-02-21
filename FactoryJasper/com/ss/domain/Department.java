package com.ss.domain;


import com.ss.base.BaseEntity;
import java.io.Serializable;
import java.util.Objects;

public class Department extends BaseEntity implements Serializable {

    public Department() {

    }

    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    // @Override
    // public int hashCode() {
    //     return Objects.hash(super.hashCode(), company);
    // }

    // @Override
    // public String toString() {
    //     final StringBuffer sb = new StringBuffer("\nDepartment{");
    //     sb.append("id: ");sb.append(this.getId());sb.append(", ");
    //     sb.append("version: ");sb.append(this.getVersion());sb.append(", ");
    //     sb.append("code: ");sb.append(this.getCode());sb.append(", ");
    //     sb.append("name: ");sb.append(this.getName());sb.append(", ");
    //     sb.append("active: ");sb.append(this.getActive());sb.append(", ");sb.append("\n");
    //     sb.append("\tCompany: [");
    //         sb.append("id: ");sb.append(company.getId());sb.append(", ");
    //         sb.append("version: ");sb.append(company.getVersion());sb.append(", ");
    //         sb.append("code: ");sb.append(company.getCode());sb.append(", ");
    //         sb.append("name: ");sb.append(company.getName());sb.append(", ");
    //         sb.append("active: ");sb.append(company.getActive());sb.append("]\n");

    //     return sb.toString();
    // }
}
