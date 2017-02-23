package com.ss.domain;
import com.ss.base.BaseEntity;

public class AppMenu extends BaseEntity {

    public AppMenu() {

    }

    private String url;
    private Integer menuType;

     public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }
}
