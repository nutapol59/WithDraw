package com.ss.controller;

import com.ss.domain.Customer;
import com.ss.service.seviceImpl.CustomerServiceImpl;
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

@CrossOrigin(origins = "http://localhost:4200") //develop Mode
// @CrossOrigin(origins = "http://103.208.24.217:4200") //production Mode
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

    private CustomerServiceImpl customerServiceImpl;

    @Autowired
    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }


    @RequestMapping(value = "/addCustomer",method = RequestMethod.POST,headers = "Accept=application/json")
    public ResponseEntity<String> addCustomer(@RequestBody String json){
        log.info(">>>>>>>>>>>>>>>>>>>>>ADD CUSTOMERS<<<<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result = this.customerServiceImpl.addCustomer(json);
        if(result.equals("Save Success")){
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.CREATED);
        }else
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @RequestMapping(value="/getCustomers" ,method = RequestMethod.GET,headers = "Accept=application/json")
    public ResponseEntity<String> getCustomers(){
        log.info(">>>>>>>>>>>>>>>>>>>>>GET CUSTOMERS<<<<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<Customer> list = new ArrayList<>();
        try {

            list =  this.customerServiceImpl.getCustomers();
            log.info("{}",list);

            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(list),headers,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(e),headers,HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }

    @RequestMapping(value = "/updateCustomer",method = RequestMethod.PUT,headers = "Accept=application/json")
    public ResponseEntity<String> updateCompanies(@RequestBody String json){
        log.info(">>>>>>>>>>>>>>>>>>>>UPDATE CUSTOMER<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result;

        try{
            result = this.customerServiceImpl.updateCustomer(json);
            if(result.equals("Update Success")){
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.OK);
            }else
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(e), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @RequestMapping(value = "/deleteCustomer/{id}",method = RequestMethod.DELETE,headers = "Accept=application/json")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        log.info(">>>>>>>>>>>>>>>>>>>>DELETE CUSTOMER<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result;
        try{
            result = this.customerServiceImpl.deleteCustomer(id);
            log.info("result= {}",result.equalsIgnoreCase("Delete Success"));
            if(result.equalsIgnoreCase("Delete Success")){

                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result),headers, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result),headers, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(e),headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
