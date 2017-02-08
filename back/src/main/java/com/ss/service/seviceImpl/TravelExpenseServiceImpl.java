package com.ss.service.seviceImpl;


import com.ss.domain.TravelExpense;
import com.ss.repository.TravelExpenseRepository;
import com.ss.service.TravelExpenseService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelExpenseServiceImpl  implements TravelExpenseService{
    private static final Logger log = LoggerFactory.getLogger(TravelExpenseServiceImpl.class);

    private TravelExpenseRepository travelExpenseRepository;

    @Autowired
    public TravelExpenseServiceImpl(TravelExpenseRepository travelExpenseRepository) {
        this.travelExpenseRepository = travelExpenseRepository;
    }

    @Override
    public List<TravelExpense> getTravelExpenses() {
        log.info("======== get TravelExpense ========");
        List<TravelExpense> list;
        try{
            list =  (List<TravelExpense>)this.travelExpenseRepository.findAll();
            log.info("list = {}",list);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String addTravelExpense(String json) {
       log.info("========= add TravelExpense =========");
       try{
//           JSONObject jsonObject = new JSONObject(json);
//               TravelExpense travelExpense = new TravelExpense();
//           travelExpense.setActive(jsonObject.getInt("active"));
//           travelExpense.setCode(jsonObject.getString("code"));
//           travelExpense.setName(jsonObject.getString("name"));
//           travelExpense.setCompany(company);
//               this.departmentRepository.save(department);
//               log.info("department = {}",department);
//               log.info("addDepartment Success");

               return "Created Success";

       }catch (Exception e){
           e.printStackTrace();
           return "Not Create TravelExpense";
       }
    }

    @Override
    public String updateTravelExpense(String json) {
        return null;
    }

    @Override
    public String deleteTravelExpense(Long id) {
        return null;
    }
}
