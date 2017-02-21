package com.ss.domain;
import com.ss.base.BaseEntity;
import java.util.Set;

public class AppRole extends BaseEntity {

	public AppRole() {

    }
	
    private Set<AppRoleMenu> appRoleMenus;

    public Set<AppRoleMenu> getAppRoleMenus() {
        return appRoleMenus;
    }

    public void setAppRoleMenus(Set<AppRoleMenu> appRoleMenus) {
        this.appRoleMenus = appRoleMenus;
    }
}
