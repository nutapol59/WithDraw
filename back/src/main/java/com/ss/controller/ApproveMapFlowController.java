package com.ss.controller;

import com.ss.service.seviceImpl.ApproveMapFlowServiceImpl;
import flexjson.JSONSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200") //develop Mode
// @CrossOrigin(origins = "http://103.208.24.217:4200") //production Mode
@RestController
@RequestMapping(value = "/approveMapFlows")
public class ApproveMapFlowController {
    private static final Logger log = LoggerFactory.getLogger(ApproveMapFlowController.class);
    private ApproveMapFlowServiceImpl approveMapFlowServiceImpl;

    @Autowired
    public ApproveMapFlowController(ApproveMapFlowServiceImpl approveMapFlowServiceImpl) {
        this.approveMapFlowServiceImpl = approveMapFlowServiceImpl;
    }

    @RequestMapping(value = "/getApproveMapFlows",method = RequestMethod.GET,headers = "Accept=application/json")
    public ResponseEntity<String> getApproveMapFlows(){
        log.info("=====================GET ApproveMapFlow=====================");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try{
            log.info("{}",this.approveMapFlowServiceImpl.getApproveMapFlows());
            ResponseEntity<String> re = new ResponseEntity<>(new JSONSerializer()

                    .include("id")
                    .include("employee.id")
                    .include("employee.empCode")
                    .include("employee.empName")
                    .include("employee.empLastName")
                    .include("apv1Emp.id")
                    .include("apv1Emp.empCode")
                    .include("apv1Emp.empName")
                    .include("apv1Emp.empLastName")
                    .include("apv2Emp.id")
                    .include("apv2Emp.empCode")
                    .include("apv2Emp.empName")
                    .include("apv2Emp.empLastName")
                    .include("accountEmp.id")
                    .include("accountEmp.empCode")
                    .include("accountEmp.empName")
                    .include("accountEmp.empLastName")
                    .exclude("*")
                    .deepSerialize(this.approveMapFlowServiceImpl.getApproveMapFlows()),headers, HttpStatus.OK);
            log.info("re = {}",re);
            return re;
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(this.approveMapFlowServiceImpl.getApproveMapFlows()),headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/addApproveMapFlow",method = RequestMethod.POST,headers = "Accept=application/json")
    public ResponseEntity<String> addApproveMapFlow(@RequestBody String json){
        log.info(">>>>>>>>>>>>>>>>>>>>>ADD ApproveMapFlow<<<<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result = this.approveMapFlowServiceImpl.addApproveMapFlow(json);
        if(result.equals("Save Success")){
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.CREATED);
        }else
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/updateApproveMapFlow",method = RequestMethod.PUT,headers = "Accept=application/json")
    public ResponseEntity<String> updateApproveMapFlow(@RequestBody String json){
        log.info(">>>>>>>>>>>>>>>>>>>>UPDATE ApproveMapFlow<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result = this.approveMapFlowServiceImpl.updateApproveMapFlow(json);
        if(result.equals("Update Success")){
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.OK);
        }else
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @RequestMapping(value = "/deleteApproveMapFlow/{id}",method = RequestMethod.DELETE,headers = "Accept=application/json")
    public ResponseEntity<String> deleteApproveMapFlow(@PathVariable Long id){
        log.info(">>>>>>>>>>>>>>>>>>>deleteApproveMapFlow<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result = this.approveMapFlowServiceImpl.deleteApproveMapFlow(id);
        if(result.equals("Delete Success")){
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result),headers, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result),headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
