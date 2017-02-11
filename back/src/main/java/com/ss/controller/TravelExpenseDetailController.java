package com.ss.controller;

import com.ss.service.seviceImpl.TravelExpenseDetailServiceImpl;
import flexjson.JSONSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/travelExpenseDetails")
public class TravelExpenseDetailController {
    private static final Logger log = LoggerFactory.getLogger(TravelExpenseDetailController.class);
    private TravelExpenseDetailServiceImpl travelExpenseDetailServiceImpl;

    @Autowired
    public TravelExpenseDetailController(TravelExpenseDetailServiceImpl travelExpenseDetailServiceImpl) {
        this.travelExpenseDetailServiceImpl = travelExpenseDetailServiceImpl;
    }


    @RequestMapping(value = "/addTravelExpenseDetail" ,method = RequestMethod.POST,headers = "Accept=application/json" )
    public ResponseEntity<String> addTravelExpenseDetail(@RequestBody String json){
        log.info("---------------Add Travel Expense Detail---------------");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result;
        try{
            result = this.travelExpenseDetailServiceImpl.addTravelExpenseDetail(json);
            if(result.equalsIgnoreCase("Created Success")){
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result),headers, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result),headers,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize("Add Failed"),headers,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
