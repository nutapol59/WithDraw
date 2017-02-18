package com.ss.controller;


import com.ss.service.seviceImpl.BankServiceImpl;
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
@RequestMapping("/banks")
public class BankController {
    private static final Logger log = LoggerFactory.getLogger(BankController.class);
    private BankServiceImpl bankServiceImpl;

    @Autowired
    public BankController(BankServiceImpl bankServiceImpl) {
        this.bankServiceImpl = bankServiceImpl;
    }

    @RequestMapping(value = "/getBanks",method = RequestMethod.GET,headers = "Accept=application/json")
    public ResponseEntity<String> getBanks(){
        log.info("=====================GET BANKS=====================");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try{
            log.debug("{}",this.bankServiceImpl.getBanks());

            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(this.bankServiceImpl.getBanks()),headers, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(this.bankServiceImpl.getBanks()),headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/addBank",method = RequestMethod.POST,headers = "Accept=application/json")
    public ResponseEntity<String> addCompany(@RequestBody String json){
        log.info(">>>>>>>>>>>>>>>>>>>>>ADD BANKS<<<<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result = this.bankServiceImpl.addBank(json);
        if(result.equals("Save Success")){
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.CREATED);
        }else
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/updateBank",method = RequestMethod.PUT,headers = "Accept=application/json")
    public ResponseEntity<String> updateBanks(@RequestBody String json){
        log.info(">>>>>>>>>>>>>>>>>>>>UPDATE Banks<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result = this.bankServiceImpl.updateBank(json);
        if(result.equals("Update Success")){
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.OK);
        }else
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result), headers, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @RequestMapping(value = "/deleteBank/{id}",method = RequestMethod.DELETE,headers = "Accept=application/json")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        log.info(">>>>>>>>>>>>>>>>>>>>DELETE Banks<<<<<<<<<<<<<<<<<<<<<<");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String result = this.bankServiceImpl.deleteBank(id);
        if(result.equals("Delete Success")){
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result),headers, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new JSONSerializer().exclude("*.class").deepSerialize(result),headers, HttpStatus.CONFLICT);
        }

    }
}
