package com.ss.controller;

import com.ss.domain.TravelExpense;
import com.ss.service.seviceImpl.TravelExpenseServiceImpl;
import flexjson.JSONSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "travelExpenses")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TravelExpenseController {
    private static final Logger log = LoggerFactory.getLogger(CompanyController.class);
    private TravelExpenseServiceImpl travelExpenseServiceImpl;

    @Autowired
    public TravelExpenseController(TravelExpenseServiceImpl travelExpenseServiceImpl) {
        this.travelExpenseServiceImpl = travelExpenseServiceImpl;
    }

    @RequestMapping(value="/getTravelExpenses" ,method = RequestMethod.GET,headers = "Accept=application/json")
    public ResponseEntity<String> getTravelExpenses(){
        log.info(">>>>>>>>>>>>>>>>>>>>>GET Travel Expense<<<<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<TravelExpense> list = new ArrayList<>();
        try {
            log.info("---------------------------------------------------");
            list =  this.travelExpenseServiceImpl.getTravelExpenses();
            log.info("{}",list);

            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(list),headers, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(e),headers,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
