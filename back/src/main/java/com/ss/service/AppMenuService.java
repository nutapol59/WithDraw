package com.ss.service;


import com.ss.domain.AppMenu;

import java.util.List;

public interface AppMenuService {
    List<AppMenu> getAppMenues();
    String addAppRole(String json);
    String updateRole(String json);
    String deleteRole(Long id);
}
