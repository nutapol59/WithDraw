package com.ss.controller;


import com.ss.domain.Customer;
import flexjson.JSONSerializer;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @RequestMapping(value = "/addCompany",method = RequestMethod.POST,headers = "Accept=application/json")
    public ResponseEntity<String> createCompany(@RequestBody String json){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject(json);



        //this.customerRepository.save(new Customer(name,lastname,age));

        return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize("save success"), headers, HttpStatus.CREATED);


    }
//    public ResponseEntity<String>

}
