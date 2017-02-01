package com.ss.domain;


import com.ss.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppRoleMenu extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appRole")
    private AppRole appRole;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appMenu")
    private AppMenu appMenu;
}
