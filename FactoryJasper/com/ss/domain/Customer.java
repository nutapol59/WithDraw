package com.ss.domain;


import com.ss.base.BaseEntity;

public class Customer extends BaseEntity {

    public Customer() {

    }    

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // @Override
    // public String toString() {
    //     final StringBuffer sb = new StringBuffer("\nCustomer{");
    //     sb.append("id: ");sb.append(this.getId());sb.append(", ");
    //     sb.append("version: ");sb.append(this.getVersion());sb.append(", ");
    //     sb.append("code: ");sb.append(this.getCode());sb.append(", ");
    //     sb.append("name: ");sb.append(this.getName());sb.append(", ");
    //     sb.append("active: ");sb.append(this.getActive());sb.append(",\n");
    //     sb.append("address: ");sb.append(this.getAddress());sb.append(",\n");
    //     sb.append("} \n");
    //     return sb.toString();
    // }
}
