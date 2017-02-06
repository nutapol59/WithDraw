package com.ss.controller;

import com.ss.domain.Department;
import com.ss.service.seviceImpl.DepartmentServiceImpl;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
    private DepartmentServiceImpl departmentServiceImpl;

    @Autowired
    public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }

    @RequestMapping(value = "/getDepartments", method = RequestMethod.GET,headers = "Accept=application/json")
    public ResponseEntity<String> getDepartments(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<Department> list = new ArrayList<>();
        try{
            log.info("=====================GET DEPARTMENTS=====================");
            list = this.departmentServiceImpl.getDepartments();
            log.info("-------------------------------------------------------");
            log.info("{}",list);
            log.info("size = {}",list.size());
            log.info("==============================end GetDepartment===============================");
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(list),headers, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize("Error Exception From Back-End"),headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @RequestMapping(value = "/addDepartment",method = RequestMethod.POST,headers = "Accept=application/json")
    public ResponseEntity<String> addDepartment(@RequestBody String json){
        log.info(">>>>>>>>>>>>>>>>>>>>>ADD DEPARTMENT<<<<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result;
        try{
            result = this.departmentServiceImpl.addDepartment(json);
            if(result.equals("Save Success")){
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.CREATED);
            }else
                return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(e), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/updateDepartment",method = RequestMethod.PUT,headers = "Accept=application/json")
    public ResponseEntity<String> updateDepartment(@RequestBody String json){
        log.info(">>>>>>>>>>>>>>>>>>>>UPDATE Department<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result;
        try{
            result = this.departmentServiceImpl.updateDepartment(json);
            log.info("resultIMPL =  {}",result);
            log.info("before if update department");
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
    @RequestMapping(value = "/deleteDepartment/{id}",method = RequestMethod.DELETE,headers = "Accept=application/json")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        log.info(">>>>>>>>>>>>>>>>>>>>DELETE Department<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result;
        try {
            result = this.departmentServiceImpl.deleteDepartment(id);
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
