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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") //develop Mode
// @CrossOrigin(origins = "http://103.208.24.217:4200") //production Mode
@RequestMapping(value = "travelExpenses")
@RestController
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

            return new ResponseEntity<>(new JSONSerializer()
                    .include("expenseDate")
                    .include("employee.id")
                    .include("comment")
                    .include("approvelDate")
                    .include("payDate")
                    .include("cash")
                    .include("chequeBank")
                    .include("expenseSummary")
                    .include("travelExpenseDetails.id")
                    .include("documentApproves")
                    .include("documentStatus")
                    .include("approveMapFlow.id")
                    .exclude("*")
                    .deepSerialize(list),headers, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize("Error"),headers,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/getTravelExpensesByAppUserId" ,method = RequestMethod.POST,headers = "Accept=application/json")
    public ResponseEntity<String> getTravelExpensesByAppUserId(@RequestParam(value = "appUserId") Long appUserId){
        log.info("-------------------------GET Travel Expense By AppUserId-------------------------");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<TravelExpense> list = new ArrayList<>();
        try {
            log.info("---------------------------------------------------");
            list =  this.travelExpenseServiceImpl.getTravelExpensesByAppUserId(appUserId);
            log.info("{}",list);

            return new ResponseEntity<>(new JSONSerializer()
                    .include("expenseDate")
                    .include("employee.id")
                    .include("comment")
                    .include("approvelDate")
                    .include("payDate")
                    .include("cash")
                    .include("chequeBank")
                    .include("expenseSummary")
                    .include("travelExpenseDetails.id")
                    .include("documentApproves")
                    .include("documentStatus")
                    .include("approveMapFlow.id")
                    .exclude("*")
                    .deepSerialize(list),headers, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize("Error"),headers,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/addTravelExpense" ,method = RequestMethod.POST,headers = "Accept=application/json" )
    public ResponseEntity<String> addTravelExpense(@RequestBody String json){
        log.info("---------------Add Travel Expense---------------");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Long travelExpenseId;
        try{
            travelExpenseId = this.travelExpenseServiceImpl.addTravelExpense(json);
            if(travelExpenseId != null){
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(travelExpenseId),headers, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize("Error"),headers,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize("Add Failed"),headers,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateTravelExpense" ,method = RequestMethod.PUT,headers = "Accept=application/json" )
    public ResponseEntity<String> updateTravelExpense(@RequestBody String json){
        log.info("---------------updateTravelExpense---------------");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Long travelExpenseId;
        try{
            travelExpenseId = this.travelExpenseServiceImpl.updateTravelExpense(json);
            if(travelExpenseId != null){
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(travelExpenseId),headers, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize("Error"),headers,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize("Update Failed"),headers,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/deleteTravelExpense/{id}",method = RequestMethod.DELETE,headers = "Accept=application/json")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        log.info("---------DELETE TravelExpense---------");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result;
        try {
            result = this.travelExpenseServiceImpl.deleteTravelExpense(id);
            log.info("result= {}", result.equalsIgnoreCase("Delete Success"));
            if (result.equalsIgnoreCase("Delete Success")) {

                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(e), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
