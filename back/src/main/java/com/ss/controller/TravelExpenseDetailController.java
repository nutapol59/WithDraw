package com.ss.controller;

import com.ss.domain.TravelExpenseDetail;
import com.ss.service.seviceImpl.TravelExpenseDetailServiceImpl;
import flexjson.JSONSerializer;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") //develop Mode
// @CrossOrigin(origins = "http://103.208.24.217:4200") //production Mode
@RestController
@RequestMapping("/travelExpenseDetails")
public class TravelExpenseDetailController {
    private static final Logger log = LoggerFactory.getLogger(TravelExpenseDetailController.class);
    private TravelExpenseDetailServiceImpl travelExpenseDetailServiceImpl;

    @Autowired
    public TravelExpenseDetailController(TravelExpenseDetailServiceImpl travelExpenseDetailServiceImpl) {
        this.travelExpenseDetailServiceImpl = travelExpenseDetailServiceImpl;
    }


    @RequestMapping(value = "/getTravelExpenseDetails" ,method = RequestMethod.GET,headers = "Accept=application/json" )
    public ResponseEntity<String> getTravelExpenseDetails(){
        log.info("==============Get TravelExpenseDetails==============");
        HttpHeaders headers = new HttpHeaders();
        try {

            headers.add("Content-Type", "application/json; charset=utf-8");
            List<TravelExpenseDetail> list = this.travelExpenseDetailServiceImpl.getTravelExpenseDetails();
            log.info("List =  {}", list);
            return new ResponseEntity<>(new JSONSerializer()
                    .include("id")
                    .include("travelDate")
                    .include("customer.id")
                    .include("customer.code")
                    .include("customer.name")
                    .include("customer.active")
                    .include("customer.address")
                    .include("travelFrom")
                    .include("travelTo")
                    .include("expense")
                    .include("expWayExpense")
                    .include("expenseSubSummary")
                    .include("comment")
                    .include("attachFile1")
                    .include("attachFile2")
                    .include("attachFile3")
                    .include("travelExpense.id")
                    .exclude("*")
                    .deepSerialize(list),headers,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer()
                    .exclude("*.class")
                    .deepSerialize("Error"),headers,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/getTravelExpenseDetailsByTravelExpenseId" ,method = RequestMethod.POST,headers = "Accept=application/json" )
    public ResponseEntity<String> getTravelExpenseDetailsByTravelExpenserId(@RequestParam(value = "travelExpenseId") Long travelExpenseId){
        log.info("==============Get TravelExpenseDetailsByTravelExpenseId==============");
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.add("Content-Type", "application/json; charset=utf-8");
            List<TravelExpenseDetail> list = this.travelExpenseDetailServiceImpl.getTravelExpenseDetailsByTravelExpenseId(travelExpenseId);
            log.info("List =  {}", list);
            return new ResponseEntity<>(new JSONSerializer()
                    .include("id")
                    .include("travelDate")
                    .include("customer.id")
                    .include("customer.code")
                    .include("customer.name")
                    .include("customer.active")
                    .include("customer.address")
                    .include("travelFrom")
                    .include("travelTo")
                    .include("expense")
                    .include("expWayExpense")
                    .include("expenseSubSummary")
                    .include("comment")
                    .include("attachFile1")
                    .include("attachFile2")
                    .include("attachFile3")
                    .include("travelExpense.id")
                    .exclude("*")
                    .deepSerialize(list),headers,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer()
                    .exclude("*.class")
                    .deepSerialize("Error"),headers,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/addTravelExpenseDetail" ,method = RequestMethod.POST,headers = "Accept=application/json")
    public ResponseEntity<String> addTravelExpenseDetail(@Valid TravelExpenseDetail formData,MultipartHttpServletRequest multipartHttpServletRequest){
        log.info("---------------Add Travel Expense Detail---------------");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        log.info("formData TravelDate = {}",formData.getTravelDate());


        String result;
        try{
            result = this.travelExpenseDetailServiceImpl.addTravelExpenseDetail(formData,multipartHttpServletRequest);
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


    @RequestMapping(value = "/updateTravelExpenseDetail" ,method = RequestMethod.POST,headers = "Accept=application/json" )
    public ResponseEntity<String> updateTravelExpenseDetail(@Valid TravelExpenseDetail formData,MultipartHttpServletRequest multipartHttpServletRequest){
        log.info("---------------Update Travel Expense Detail---------------");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result;
        try{
            result = this.travelExpenseDetailServiceImpl.updateTravelExpenseDetail(formData,multipartHttpServletRequest);
            if(result.equalsIgnoreCase("Update Success")){
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result),headers, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result),headers,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize("Update Failed"),headers,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteTravelExpenseDetail/{id}",method = RequestMethod.DELETE,headers = "Accept=application/json")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        log.info("---------DELETE TravelExpenseDetail---------");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result;
        try{
            result = this.travelExpenseDetailServiceImpl.deleteTravelExpenseDetail(id);
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

    @RequestMapping(value = "/showPreview", method = RequestMethod.GET,headers = "Accept=application/json")
    public ResponseEntity<String> showPreview(@RequestParam(value = "travelExpenseDetailId") Long id, @RequestParam(value = "filenumber") Integer filenumber,
                                              HttpServletResponse response) throws ServletException, IOException {
        log.info("----------showPreview-----------");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try{
            inputStream = this.travelExpenseDetailServiceImpl.showPreview(id,filenumber);
            outputStream = response.getOutputStream();
            IOUtils.copy(inputStream,outputStream);
            log.info("OutputStream = {}",outputStream);
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),headers,HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
        }

    }


}
