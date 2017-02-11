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

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TravelExpenseDetailServiceImpl implements TravelExpenseDetailService{
    private static final Logger log = LoggerFactory.getLogger(TravelExpenseDetailServiceImpl.class);

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
        return null;
    }

    @Override
    public String addTravelExpenseDetail(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);

            Map<String,Object> travelExpenseDetailMap = new JSONDeserializer<Map<String,Object>>().deserialize(jsonObject.get("travelExpenseDetail").toString());

            log.info("MapDetail =  {}",travelExpenseDetailMap);
//            TravelExpenseDetail travelExpenseDetail = travelExpenseDetailMap.get("travelExpenseDetail");



            TravelExpenseDetail travelExpenseDetail = new TravelExpenseDetail();
            travelExpenseDetail.setTravelFrom((String)travelExpenseDetailMap.get("travelFrom"));
            travelExpenseDetail.setTravelTo((String)travelExpenseDetailMap.get("travelTo"));
            travelExpenseDetail.setComment((String)travelExpenseDetailMap.get("comment"));
            travelExpenseDetail.setExpense(new BigDecimal(travelExpenseDetailMap.get("expense")+""));
            travelExpenseDetail.setExpWayExpense(new BigDecimal(travelExpenseDetailMap.get("expWayExpense")+""));
            travelExpenseDetail.setExpenseSubSummary(new BigDecimal(travelExpenseDetailMap.get("expenseSubSummary")+""));

            TravelExpense travelExpense = this.travelExpenseRepository.findOne(jsonObject.getLong("travelExpenseId"));
            travelExpenseDetail.setTravelExpense(travelExpense);

            Customer customer = this.customerRepository.findOne(Long.parseLong(travelExpenseDetailMap.get("customer")+""));
            travelExpenseDetail.setCustomer(customer);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            travelExpenseDetail.setTravelDate(formatter.parse(""+travelExpenseDetailMap.get("travelDate")));
//            travelExpenseDetail.setAttachFile1("attachFile1");
//            travelExpenseDetail.setAttachFile2("attachFile2");
//            travelExpenseDetail.setAttachFile3("attachFile3");


            travelExpenseDetail.setTravelExpense(travelExpense);
            this.travelExpenseDetailRepository.save(travelExpenseDetail);

            return "Created Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Save Failed";
        }
    }

    @Override
    public String updateTravelExpenseDetail(String json) {
        return null;
    }

    @Override
    public String deleteTravelExpenseDetail(Long id) {
        return null;
    }
}
