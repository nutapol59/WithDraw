package com.ss.domain;

import com.ss.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Entity
public class AppUserRole extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appUser")
    private AppUser appUser;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="appRole")
    private AppRole appRole;
}
