package com.ss.service.seviceImpl;


import com.ss.domain.AppUser;
import com.ss.domain.ApproveMapFlow;
import com.ss.repository.AppUserRepository;
import com.ss.repository.ApproveMapFlowRepository;
import com.ss.service.ApproveMapFlowService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApproveMapFlowServiceImpl implements ApproveMapFlowService {
    private static final Logger logger = LoggerFactory.getLogger(ApproveMapFlowServiceImpl.class);
    private ApproveMapFlowRepository approveMapFlowRepository;
    private AppUserRepository appUserRepository;

    @Autowired
    public ApproveMapFlowServiceImpl(ApproveMapFlowRepository approveMapFlowRepository, AppUserRepository appUserRepository) {
        this.approveMapFlowRepository = approveMapFlowRepository;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public List<ApproveMapFlow> getApproveMapFlows() {
        try{
            return this.approveMapFlowRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String addApproveMapFlow(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            ApproveMapFlow approveMapFlow = new ApproveMapFlow();
            Long employeeId = jsonObject.getLong("employeeId");
            Long apv1Id = jsonObject.getLong("apv1Id");
            Long apv2Id = jsonObject.getLong("apv2Id");
            Long accountId = jsonObject.getLong("accountId");
            AppUser employee = this.appUserRepository.findOne(employeeId);
            AppUser apv1 = this.appUserRepository.findOne(apv1Id);
            AppUser apv2 = this.appUserRepository.findOne(apv2Id);
            AppUser account = this.appUserRepository.findOne(accountId);

            approveMapFlow.setEmployee(employee);
            approveMapFlow.setApv1Emp(apv1);
            approveMapFlow.setApv2Emp(apv2);
            approveMapFlow.setAccountEmp(account);

            this.approveMapFlowRepository.save(approveMapFlow);

            return "Save Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Save Failed";
        }
    }

    @Override
    public String updateApproveMapFlow(String json) {
        JSONObject jsonObject = new JSONObject(json);
        try{

            Long apvmfId = jsonObject.getLong("apvmfId");
            Long employeeId = jsonObject.getLong("employeeId");
            Long apv1Id = jsonObject.getLong("apv1Id");
            Long apv2Id = jsonObject.getLong("apv2Id");
            Long accountId = jsonObject.getLong("accountId");
            ApproveMapFlow approveMapFlow = this.approveMapFlowRepository.findOne(apvmfId);
            if(approveMapFlow != null) {
                AppUser employee = this.appUserRepository.findOne(employeeId);
                AppUser apv1 = this.appUserRepository.findOne(apv1Id);
                AppUser apv2 = this.appUserRepository.findOne(apv2Id);
                AppUser account = this.appUserRepository.findOne(accountId);

                approveMapFlow.setEmployee(employee);
                approveMapFlow.setApv1Emp(apv1);
                approveMapFlow.setApv2Emp(apv2);
                approveMapFlow.setAccountEmp(account);

                this.approveMapFlowRepository.save(approveMapFlow);
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
    public String deleteApproveMapFlow(Long id) {
        try{
            ApproveMapFlow approveMapFlow = this.approveMapFlowRepository.findOne(id);
            if(approveMapFlow != null){
                this.approveMapFlowRepository.delete(approveMapFlow);
                return "Delete Success";
            }else{
                return "Delete Failed";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "Delete Failed";
        }
    }
}
