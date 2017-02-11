package com.ss.service.seviceImpl;


import com.ss.domain.AppUser;
import com.ss.domain.ApproveMapFlow;
import com.ss.domain.DocumentApprove;
import com.ss.domain.TravelExpense;
import com.ss.repository.AppUserRepository;
import com.ss.repository.ApproveMapFlowRepository;
import com.ss.repository.TravelExpenseRepository;
import com.ss.service.TravelExpenseService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.leftPad;

@Service
public class TravelExpenseServiceImpl  implements TravelExpenseService{
    private static final Logger log = LoggerFactory.getLogger(TravelExpenseServiceImpl.class);

    private TravelExpenseRepository travelExpenseRepository;
    private AppUserRepository appUserRepository;
    private ApproveMapFlowRepository approveMapFlowRepository;

    @Autowired
    public TravelExpenseServiceImpl(TravelExpenseRepository travelExpenseRepository, AppUserRepository appUserRepository, ApproveMapFlowRepository approveMapFlowRepository) {
        this.travelExpenseRepository = travelExpenseRepository;
        this.appUserRepository = appUserRepository;
        this.approveMapFlowRepository = approveMapFlowRepository;
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
    public synchronized Long addTravelExpense(String json) {
       log.info("========= add TravelExpense =========");
       try{
           JSONObject jsonObject = new JSONObject(json);
           Long appUserId = jsonObject.getLong("appUserId");
           log.info("appUserId = {}",appUserId);
//           Long companyId = jsonObject.getLong("companyId");
//           Long departmentId = jsonObject.getLong("departmentId");
           String comment = jsonObject.getString("comment");
           AppUser appUser = this.appUserRepository.findOne(appUserId);
           TravelExpense travelExpense = new TravelExpense();
           travelExpense.setEmployee(appUser);
           travelExpense.setCompany(appUser.getCompany());
           travelExpense.setDepartment(appUser.getDepartment());
           if(comment != null){
               travelExpense.setComment(comment);
           }else{
               travelExpense.setComment(null);
           }

           ApproveMapFlow approveMapFlow = this.approveMapFlowRepository.findApproveMapFlowByAppUserId(appUserId);

           Set<DocumentApprove> daSet = new HashSet<>();

           DocumentApprove documentApprove1 = new DocumentApprove();
           documentApprove1.setApprover(approveMapFlow.getApv1Emp());
           documentApprove1.setSequence(0);

           DocumentApprove documentApprove2 = new DocumentApprove();
           documentApprove2.setApprover(approveMapFlow.getApv2Emp());
           documentApprove2.setSequence(1);

           DocumentApprove documentApprove3 = new DocumentApprove();
           documentApprove3.setApprover(approveMapFlow.getAccountEmp());
           documentApprove3.setSequence(2);

           daSet.add(documentApprove1);
           daSet.add(documentApprove2);
           daSet.add(documentApprove3);
           travelExpense.setDocumentApproves(daSet);

           log.info("APPROVE MAP FLOW = {} ",approveMapFlow);
           travelExpense.setApproveMapFlow(approveMapFlow);
           travelExpense.setDocumentDate(new Date());
           travelExpense.setExpenseDate(new Date());

           travelExpense.setApproveSeq(0);

           String lastTravelExpenseNumber = "TE" +
                   leftPad(  (Long.parseLong(this.travelExpenseRepository.findAllCustom().substring(2))  +1L)+"",6,"0");
           log.info(lastTravelExpenseNumber);
           travelExpense.setDocumentNumber(lastTravelExpenseNumber);
           this.travelExpenseRepository.save(travelExpense);

           log.info("TravelExpense Id = {}",travelExpense.getId());



               return travelExpense.getId();

       }catch (Exception e){
           e.printStackTrace();
           return null;
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
