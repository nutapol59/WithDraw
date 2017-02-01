package com.ss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ss.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Entity
public class AppMenu extends BaseEntity {

    @Column
    private String url;

    @Column
    private Integer menuType;
}
