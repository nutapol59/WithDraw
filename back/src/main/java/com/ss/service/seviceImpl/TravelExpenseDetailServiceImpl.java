package com.ss.service.seviceImpl;
import com.ss.domain.Customer;
import com.ss.domain.TravelExpense;
import com.ss.domain.TravelExpenseDetail;
import com.ss.repository.CustomerRepository;
import com.ss.repository.TravelExpenseDetailRepository;
import com.ss.repository.TravelExpenseRepository;
import com.ss.service.TravelExpenseDetailService;
import flexjson.JSONDeserializer;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TravelExpenseDetailServiceImpl implements TravelExpenseDetailService{
    private static final Logger log = LoggerFactory.getLogger(TravelExpenseDetailServiceImpl.class);
    private static final String pathUpload = "/home/nbkf/Working/TempWithDrawFile/";

    private TravelExpenseDetailRepository travelExpenseDetailRepository;
    private TravelExpenseRepository travelExpenseRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public TravelExpenseDetailServiceImpl(TravelExpenseDetailRepository travelExpenseDetailRepository, TravelExpenseRepository travelExpenseRepository, CustomerRepository customerRepository) {
        this.travelExpenseDetailRepository = travelExpenseDetailRepository;
        this.travelExpenseRepository = travelExpenseRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<TravelExpenseDetail> getTravelExpenseDetails() {
        try{
            return this.travelExpenseDetailRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TravelExpenseDetail> getTravelExpenseDetailsByTravelExpenseId(Long travelExpenseId) {
        try{
            List<TravelExpenseDetail> list = this.travelExpenseDetailRepository.getTravelExpenseDetailsByTravelExpenseId(travelExpenseId);
            log.info("LIST TravelExpenseDetail = {}",list);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public String addTravelExpenseDetail(TravelExpenseDetail formdata, MultipartHttpServletRequest multipartHttpServletRequest) {
        try {

            if(!formdata.getAttachFile1().equalsIgnoreCase("")){
                MultipartFile multipartFile1 = multipartHttpServletRequest.getFile("file1"); //getFile
                byte[] bytesFile1 = multipartFile1.getBytes(); //get byte file
                FileCopyUtils.copy(bytesFile1, new FileOutputStream(pathUpload+ formdata.getAttachFile1()));
            }


            if(!formdata.getAttachFile2().equalsIgnoreCase("")) {
                MultipartFile multipartFile2 = multipartHttpServletRequest.getFile("file2");
                byte[] bytesFile2 = multipartFile2.getBytes(); //get byte file
                FileCopyUtils.copy(bytesFile2, new FileOutputStream(pathUpload + formdata.getAttachFile2()));
            }


            if(!formdata.getAttachFile3().equalsIgnoreCase("")) {
                MultipartFile multipartFile3 = multipartHttpServletRequest.getFile("file3");
                byte[] bytesFile3 = multipartFile3.getBytes(); //get byte file
                FileCopyUtils.copy(bytesFile3, new FileOutputStream(pathUpload + formdata.getAttachFile3()));
                //save file to path
            }

            this.travelExpenseDetailRepository.save(formdata);

//            //JSONObject jsonObject = new JSONObject(json);
//            Map<String,Object> travelExpenseDetailMap = new JSONDeserializer<Map<String,Object>>().deserialize(jsonObject.get("travelExpenseDetail").toString());
//            log.info("MapDetail =  {}",travelExpenseDetailMap);
////            TravelExpenseDetail travelExpenseDetail = travelExpenseDetailMap.get("travelExpenseDetail");
//            TravelExpenseDetail travelExpenseDetail = new TravelExpenseDetail();
//            travelExpenseDetail.setTravelFrom((String)travelExpenseDetailMap.get("travelFrom"));
//            travelExpenseDetail.setTravelTo((String)travelExpenseDetailMap.get("travelTo"));
//            travelExpenseDetail.setComment((String)travelExpenseDetailMap.get("comment"));
//            travelExpenseDetail.setExpense(new BigDecimal(travelExpenseDetailMap.get("expense")+""));
//            travelExpenseDetail.setExpWayExpense(new BigDecimal(travelExpenseDetailMap.get("expWayExpense")+""));
//            travelExpenseDetail.setExpenseSubSummary(new BigDecimal(travelExpenseDetailMap.get("expenseSubSummary")+""));
//
//            TravelExpense travelExpense = this.travelExpenseRepository.findOne(jsonObject.getLong("travelExpenseId"));
//            travelExpenseDetail.setTravelExpense(travelExpense);
//
//            Customer customer = this.customerRepository.findOne(Long.parseLong(travelExpenseDetailMap.get("customer")+""));
//            travelExpenseDetail.setCustomer(customer);
//
//            Long date = jsonObject.getLong("date");
//            log.info("date = {}",date);
//            Date travelDate = new Date(date);
//            log.info("travelDate = {}",travelDate);
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            String dateText = formatter.format(travelDate);
//            log.info("dateText: {}",dateText);
//            travelExpenseDetail.setTravelDate(formatter.parse(dateText));
//    //            travelExpenseDetail.setAttachFile1("attachFile1");
////            travelExpenseDetail.setAttachFile2("attachFile2");
////            travelExpenseDetail.setAttachFile3("attachFile3");
//
//            this.travelExpenseDetailRepository.save(travelExpenseDetail);

            return "Created Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Save Failed";
        }
    }

    @Override
    public String updateTravelExpenseDetail(TravelExpenseDetail formdata, MultipartHttpServletRequest multipartHttpServletRequest) {
        try {
            log.info("id travelExpenseUpdate = {}",formdata.getId());
            TravelExpenseDetail travelExpenseDetail = this.travelExpenseDetailRepository.findOne(formdata.getId());
            if(travelExpenseDetail != null){

            if(!formdata.getAttachFile1().equalsIgnoreCase("")){
                MultipartFile multipartFile1 = multipartHttpServletRequest.getFile("file1"); //getFile
                byte[] bytesFile1 = multipartFile1.getBytes(); //get byte file
                FileCopyUtils.copy(bytesFile1, new FileOutputStream(pathUpload+ formdata.getAttachFile1()));
            }


            if(!formdata.getAttachFile2().equalsIgnoreCase("")) {
                MultipartFile multipartFile2 = multipartHttpServletRequest.getFile("file2");
                byte[] bytesFile2 = multipartFile2.getBytes(); //get byte file
                FileCopyUtils.copy(bytesFile2, new FileOutputStream(pathUpload + formdata.getAttachFile2()));
            }


            if(!formdata.getAttachFile3().equalsIgnoreCase("")) {
                MultipartFile multipartFile3 = multipartHttpServletRequest.getFile("file3");
                byte[] bytesFile3 = multipartFile3.getBytes(); //get byte file
                FileCopyUtils.copy(bytesFile3, new FileOutputStream(pathUpload + formdata.getAttachFile3()));
                //save file to path
            }
            log.info("customer Id Update = {}",formdata.getCustomer().getId());
            Customer customer = this.customerRepository.findOne(formdata.getCustomer().getId());
                travelExpenseDetail.setTravelDate(formdata.getTravelDate());
                travelExpenseDetail.setCustomer(formdata.getCustomer());
                travelExpenseDetail.setTravelFrom(formdata.getTravelFrom());
                travelExpenseDetail.setTravelTo(formdata.getTravelTo());
                travelExpenseDetail.setExpense(formdata.getExpense());
                travelExpenseDetail.setExpWayExpense(formdata.getExpWayExpense());
                travelExpenseDetail.setExpenseSubSummary(formdata.getExpenseSubSummary());
                travelExpenseDetail.setComment(formdata.getComment());
                travelExpenseDetail.setTravelExpense(formdata.getTravelExpense());
                travelExpenseDetail.setAttachFile1(formdata.getAttachFile1());
                travelExpenseDetail.setAttachFile2(formdata.getAttachFile2());
                travelExpenseDetail.setAttachFile3(formdata.getAttachFile3());

                this.travelExpenseDetailRepository.save(travelExpenseDetail);

                return "Update Success";

            }else {
                return "Update Failed";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Update Failed";
        }
    }

    @Override
    public String deleteTravelExpenseDetail(Long id) {
        try{
            TravelExpenseDetail travelExpenseDetail = this.travelExpenseDetailRepository.findOne(id);
            if(travelExpenseDetail != null){
                this.travelExpenseDetailRepository.delete(id);
                return "Delete Success";
            }else{
                return "Delete Failed";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "Delete Failed";
        }
    }

    @Override
    public InputStream showPreview(Long travelExpenseDetailId, Integer filenumber) {
        TravelExpenseDetail travelExpenseDetail = this.travelExpenseDetailRepository.findOne(travelExpenseDetailId);
        InputStream inputStream = null;
        String name ="";
        try {
            if(filenumber == 1){
                name = travelExpenseDetail.getAttachFile1();
            }else if(filenumber == 2){
                name = travelExpenseDetail.getAttachFile2();
            }else if(filenumber == 3){
                name = travelExpenseDetail.getAttachFile3();
            }
            inputStream = new FileInputStream(new File(pathUpload+name));

        }catch (Exception e){
            e.printStackTrace();

        }
        return inputStream;

    }


}
