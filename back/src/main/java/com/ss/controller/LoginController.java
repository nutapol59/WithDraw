package com.ss.controller;

import com.ss.service.seviceImpl.AppUserServiceImpl;
import flexjson.JSONSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Baze on 2/24/2017.
 */
@CrossOrigin(origins = "http://localhost:4200") //develop Mode
// @CrossOrigin(origins = "http://103.208.24.217:4200") //production Mode
@RestController
@RequestMapping(value = "/AuthenticationUser")
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(AppUserController.class);
    private AppUserServiceImpl appUserServiceImpl;

    @Autowired
    public LoginController(AppUserServiceImpl appUserServiceImpl) {
        this.appUserServiceImpl = appUserServiceImpl;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST,headers = "Accept=application/json")
    public ResponseEntity<String> isValidUserLogin(@RequestBody String json){
        log.info("--------------------login------------------");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            Long result = this.appUserServiceImpl.isValidUserLogin(json);
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("failed", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
