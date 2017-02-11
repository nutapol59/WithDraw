package com.ss.service;


import com.ss.domain.AppUser;

import java.util.List;

public interface AppUserService {
    List<AppUser> getAppUsers();
    String addAppUser(String json);
    String updateAppUser(String json);
    String deleteAppUser(Long id);
    AppUser getAppUserById(Long id);
}
