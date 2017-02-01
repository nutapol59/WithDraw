package com.ss.controller;


import com.ss.domain.Company;

import com.ss.repository.CompanyRepository;
import com.ss.service.seviceImpl.CompanyServiceImpl;
import flexjson.JSONSerializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/companies")
public class CompanyController {
    private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

    private CompanyServiceImpl companyServiceImpl;
    private CompanyRepository companyRepository;

    @Autowired
    public CompanyController(CompanyServiceImpl companyServiceImpl, CompanyRepository companyRepository) {
        this.companyServiceImpl = companyServiceImpl;
        this.companyRepository = companyRepository;
    }


    @RequestMapping(value = "/addCompany",method = RequestMethod.POST,headers = "Accept=application/json")
    public ResponseEntity<String> addCompany(@RequestBody String json){
        log.info(">>>>>>>>>>>>>>>>>>>>>ADD COMPANIES<<<<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result = this.companyServiceImpl.addCompany(json);
        if(result.equals("Save Success")){
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.CREATED);
        }else
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @RequestMapping(value="/getCompanies" ,method = RequestMethod.GET,headers = "Accept=application/json")
    public ResponseEntity<String> getCompanies(){
        log.info(">>>>>>>>>>>>>>>>>>>>>GET COMPANIES<<<<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        log.debug("{}",this.companyServiceImpl.getCompanies());
        return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(this.companyServiceImpl.getCompanies()),headers,HttpStatus.OK);
    }

    @RequestMapping(value = "/updateCompany",method = RequestMethod.PUT,headers = "Accept=application/json")
    public ResponseEntity<String> updateCompanies(@RequestBody String json){
        log.info(">>>>>>>>>>>>>>>>>>>>UPDATE COMPANIES<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result = this.companyServiceImpl.updateCompany(json);
        if(result.equals("Update Success")){
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.OK);
        }else
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @RequestMapping(value = "/deleteCompany/{id}",method = RequestMethod.DELETE,headers = "Accept=application/json")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        log.info(">>>>>>>>>>>>>>>>>>>>DELETE COMPANIES<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result = this.companyServiceImpl.deleteCompany(id);
        if(result.equals("Delete Success")){
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result),headers, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result),headers, HttpStatus.CONFLICT);
        }

    }

    @RequestMapping(value = "/addCompanyParam",method = RequestMethod.GET,headers = "Accept=application/json")
    public ResponseEntity<String> addCompanyByParam(@RequestParam String code,@RequestParam String name,@RequestParam Integer active){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Company company = new Company(null);
        company.setActive(active);
        company.setCode(code);
        company.setName(name);
        this.companyRepository.save(company);

        return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize("save success"), headers, HttpStatus.CREATED);

    }


//    public ResponseEntity<String>

}
