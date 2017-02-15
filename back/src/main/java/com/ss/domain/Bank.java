package com.ss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ss.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Data
public class Bank extends BaseEntity implements Serializable {




    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("\nBank{");
        sb.append("id: ");sb.append(this.getId());sb.append(", ");
        sb.append("version: ");sb.append(this.getVersion());sb.append(", ");
        sb.append("code: ");sb.append(this.getCode());sb.append(", ");
        sb.append("name: ");sb.append(this.getName());sb.append(", ");
        sb.append("active: ");sb.append(this.getActive());sb.append(",\n");
        sb.append("} \n");
        return sb.toString();
    }

}
