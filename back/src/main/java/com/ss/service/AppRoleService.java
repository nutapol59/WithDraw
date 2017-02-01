package com.ss.service;


import com.ss.domain.AppRole;

import java.util.List;

public interface AppRoleService {
    List<AppRole> getAppRoles();
    String addAppRole(String json);
    String updateAppRole(String json);
    String deleteAppRole(Long id);
}
