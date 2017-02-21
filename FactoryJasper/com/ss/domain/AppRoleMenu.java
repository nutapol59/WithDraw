package com.ss.domain;
import com.ss.base.BaseEntity;


public class AppRoleMenu extends BaseEntity{

    public AppRoleMenu() {

    }

    private AppRole appRole;
    private AppMenu appMenu;

    public AppRole getAppRole() {
       return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }

    public AppMenu getAppMenu() {
        return appMenu;
    }

    public void setAppMenu(AppMenu appMenu) {
        this.appMenu = appMenu;
    }
}
