package com.ss.controller;

import com.ss.domain.AppUser;
import com.ss.service.seviceImpl.AppUserServiceImpl;
import flexjson.JSONSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/appUsers")
@CrossOrigin(origins = "http://localhost:4200")
public class AppUserController {
    private static final Logger log = LoggerFactory.getLogger(AppUserController.class);
    private AppUserServiceImpl appUserServiceImpl;

    @Autowired
    public AppUserController(AppUserServiceImpl appUserServiceImpl) {
        this.appUserServiceImpl = appUserServiceImpl;
    }

    @RequestMapping(value = "/getAppUsers",method = RequestMethod.GET,headers = "Accept=application/json")
    public ResponseEntity<String> getAppUsers(){
        log.info(">>>>>>>>>>>>>>>>>>>>>GET USERS<<<<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<AppUser> list;
        try {

            list =  this.appUserServiceImpl.getAppUsers();
            log.info("{}",list);
//            log.info("log JSON SERIALIZE = {}",new JSONSerializer().exclude("*.class").deepSerialize(list));
            return new ResponseEntity<>(new JSONSerializer()
                    .include("id")
                    .include("version")
                    .include("empCode")
                    .include("empName")
                    .include("empLastName")
                    .include("empAddress")
                    .include("personalId")
                    .include("tel")
                    .include("email")
                    .include("ldapUserName")
                    .include("password")
                    .include("appUserRole")
                    .include("company.id")
                    .include("company.version")
                    .include("company.code")
                    .include("company.name")
                    .include("company.active")
                    .include("department.id")
                    .include("department.version")
                    .include("department.code")
                    .include("department.name")
                    .include("department.active")
                    .exclude("*")
                    .deepSerialize(list),headers,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(e),headers,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/addAppUser",method = RequestMethod.POST,headers = "Accept=application/json")
    public ResponseEntity<String> addAppUser(@RequestBody String json){
        log.info(">>>>>>>>>>>>>>>>>>>>>ADD USER<<<<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result = this.appUserServiceImpl.addAppUser(json);
        if(result.equals("Save Success")){
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.CREATED);
        }else
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/updateAppUser",method = RequestMethod.PUT,headers = "Accept=application/json")
    public ResponseEntity<String> updateDepartment(@RequestBody String json){
        log.info(">>>>>>>>>>>>>>>>>>>>UPDATE USER<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result;
        try{
            result = this.appUserServiceImpl.updateAppUser(json);
            log.info("resultIMPL =  {}",result);

            if(result.equalsIgnoreCase("Update Success")){
                log.info("result = success");
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.OK);
            }else {
                log.info("result = failed");
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize("Update Failed"), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/deleteAppUser/{id}",method = RequestMethod.DELETE,headers = "Accept=application/json")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        log.info(">>>>>>>>>>>>>>>>>>>>DELETE USER<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result;
        try {
            result = this.appUserServiceImpl.deleteAppUser(id);
            if(result.equals("Delete Success")){
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result),headers, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result),headers, HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize("Delete Failed"),headers, HttpStatus.CONFLICT);
        }


    }
}
