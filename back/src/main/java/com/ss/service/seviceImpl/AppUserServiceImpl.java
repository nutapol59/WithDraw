package com.ss.service.seviceImpl;


import com.ss.domain.AppUser;
import com.ss.domain.Company;
import com.ss.domain.Department;
import com.ss.repository.AppUserRepository;
import com.ss.repository.CompanyRepository;
import com.ss.repository.DepartmentRepository;
import com.ss.service.AppUserService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserServiceImpl  implements AppUserService{
    private AppUserRepository appUserRepository;
    private CompanyRepository companyRepository;
    private DepartmentRepository departmentRepository;

    private static final Logger log = LoggerFactory.getLogger(AppUserServiceImpl.class);
    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository, CompanyRepository companyRepository, DepartmentRepository departmentRepository) {
        this.appUserRepository = appUserRepository;
        this.companyRepository = companyRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<AppUser> getAppUsers() {
        List<AppUser> list = new ArrayList<>();
        try {
            for(AppUser appUser : this.appUserRepository.findAll()){
                list.add(appUser);
            }
            log.info("LIST IN GET APP USERS ====== {}",list);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public AppUser getAppUserById(Long id) {
        try {
            return this.appUserRepository.findOne(id);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public String addAppUser(String json) {
        try {
            log.info("===================add AppUser IMPL===================");
            JSONObject jsonObject = new JSONObject(json);
            Long idCompany = jsonObject.getLong("companyId");
            Long idDepartment = jsonObject.getLong("departmentId");
            Company company = this.companyRepository.findOne(idCompany);
            Department department = this.departmentRepository.findOne(idDepartment);

            if(company != null && department != null){
                log.info("=============into If AppUser IMPL================");
                AppUser appUser = new AppUser();
                appUser.setEmpCode(jsonObject.getString("empCode"));
                appUser.setEmpName(jsonObject.getString("empName"));
                appUser.setEmpLastName(jsonObject.getString("empLastName"));
                appUser.setEmpAddress(jsonObject.getString("empAddress"));
                appUser.setPersonalId(jsonObject.getString("personalId"));
                appUser.setTel(jsonObject.getString("tel"));
                appUser.setEmail(jsonObject.getString("email"));
                appUser.setLdapUserName(jsonObject.getString("ldapUserName"));
                appUser.setPassword(jsonObject.getString("password"));
                appUser.setDepartment(department);
                appUser.setCompany(company);
                this.appUserRepository.save(appUser);
                return "Save Success";
            }else {
                return "Save Failed Not Found Company Or Department";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "Save Failed";
        }
    }

    @Override
    public String updateAppUser(String json) {
        try{
            log.info("=============into UPDATE USER IMPL");
            JSONObject jsonObject = new JSONObject(json);
            Long idAppUser = jsonObject.getLong("id");
            Long idCompany = jsonObject.getLong("companyId");
            Long idDepartment = jsonObject.getLong("departmentId");

            Department department = this.departmentRepository.findOne(idDepartment);
            Company company = this.companyRepository.findOne(idCompany);
            AppUser appUser = this.appUserRepository.findOne(idAppUser);

            if(appUser != null){
                log.info("=============into If UpdateAppUser department != null IMPL================");
                if(company != null && department != null){
                    log.info("=============into If UpdateAppUser company != null && department != null ================");
                    appUser.setEmpCode(jsonObject.getString("empCode"));
                    appUser.setEmpName(jsonObject.getString("empName"));
                    appUser.setEmpLastName(jsonObject.getString("empLastName"));
                    appUser.setEmpAddress(jsonObject.getString("empAddress"));
                    appUser.setPersonalId(jsonObject.getString("personalId"));
                    appUser.setTel(jsonObject.getString("tel"));
                    appUser.setEmail(jsonObject.getString("email"));
                    appUser.setLdapUserName(jsonObject.getString("ldapUserName"));
                    appUser.setPassword(jsonObject.getString("password"));
                    appUser.setDepartment(department);
                    appUser.setCompany(company);
                    this.appUserRepository.save(appUser);
                    return "Update Success";
                }else {
                    return "Update Failed Not Found Company Or Department";
                }
            }else {
                return "not Found Department";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "Update Failed";
        }
    }

    @Override
    public String deleteAppUser(Long id) {
        try {
            AppUser appUser = this.appUserRepository.findOne(id);
            if (appUser != null){
                this.appUserRepository.delete(id);
                return "Delete Success";
            }else
                return "Delete Failed Not Found Department";
        }catch (Exception e){
            e.printStackTrace();
            return "Delete Failed Not Found Department";
        }
    }


}
