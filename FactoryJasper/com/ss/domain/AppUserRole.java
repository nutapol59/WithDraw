package com.ss.domain;

import com.ss.base.BaseEntity;

public class AppUserRole extends BaseEntity {

    public AppUserRole() {

    }

    private AppUser appUser;
    private AppRole appRole;


    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
}
