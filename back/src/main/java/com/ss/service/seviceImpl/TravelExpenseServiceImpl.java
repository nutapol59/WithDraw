package com.ss.service.seviceImpl;


import com.ss.domain.*;
import com.ss.repository.AppUserRepository;
import com.ss.repository.ApproveMapFlowRepository;
import com.ss.repository.TravelExpenseDetailRepository;
import com.ss.repository.TravelExpenseRepository;
import com.ss.service.TravelExpenseService;
import com.ss.util.AbstractReportJasperPDF;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.leftPad;

@Service
public class TravelExpenseServiceImpl  implements TravelExpenseService{
    private static final Logger log = LoggerFactory.getLogger(TravelExpenseServiceImpl.class);

    private TravelExpenseRepository travelExpenseRepository;
    private TravelExpenseDetailRepository travelExpenseDetailRepository;
    private AppUserRepository appUserRepository;
    private ApproveMapFlowRepository approveMapFlowRepository;

    @Autowired
    public TravelExpenseServiceImpl(TravelExpenseRepository travelExpenseRepository, TravelExpenseDetailRepository travelExpenseDetailRepository, AppUserRepository appUserRepository, ApproveMapFlowRepository approveMapFlowRepository) {
        this.travelExpenseRepository = travelExpenseRepository;
        this.travelExpenseDetailRepository = travelExpenseDetailRepository;
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
    public List<TravelExpense> getTravelExpensesByAppUserId(Long appUserId) {
        log.info("======== get TravelExpenseByAppUserId ========");
        List<TravelExpense> list;
        try{
            list = this.travelExpenseRepository.getTravelExpensesByAppUserId(appUserId);
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
            String docNumber = this.travelExpenseRepository.lastTravelExpenseNumber();
           if(docNumber==null){
               travelExpense.setDocumentNumber("TE000000");
           }else {
               String lastTravelExpenseNumber = "TE" +
                       leftPad(  (Long.parseLong(docNumber.substring(2))  +1L)+"",6,"0");
               log.info(lastTravelExpenseNumber);
               travelExpense.setDocumentNumber(lastTravelExpenseNumber);
           }

           this.travelExpenseRepository.save(travelExpense);

           log.info("TravelExpense Id = {}",travelExpense.getId());
           return travelExpense.getId();

       }catch (Exception e){
           e.printStackTrace();
           return null;
       }
    }

    @Override
    public String addExpenseSummary(String json) {
        JSONObject jsonObject = new JSONObject(json);
        log.info("addExpenseSummary JSON = {}",json);
        try{
            Long travelExpenseId = jsonObject.getLong("travelExpenseId");
            TravelExpense travelExpense = this.travelExpenseRepository.findOne(travelExpenseId);
            if(travelExpense != null){
                travelExpense.setExpenseSummary(new BigDecimal(jsonObject.getInt("expenseSummary")));
                this.travelExpenseRepository.save(travelExpense);
                return "Save Success";
            }else {
                return "Save Failed";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "Save Failed";
        }

    }

    @Override
    public Long updateTravelExpense(String json) {
        log.info("------- add TravelExpense --------");
        JSONObject jsonObject = new JSONObject(json);
        try{
            Long travelExpenseId = jsonObject.getLong("travelExpenseId");
            log.info("travelExpenseId in Update = {}",travelExpenseId);
            TravelExpense travelExpense = this.travelExpenseRepository.findOne(travelExpenseId);
            if(travelExpense != null){
                travelExpense.setComment(jsonObject.getString("comment"));
                return travelExpense.getId();
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String deleteTravelExpense(Long id) {
        try{
            TravelExpense travelExpense = this.travelExpenseRepository.findOne(id);
            if(travelExpense != null){
                this.travelExpenseRepository.delete(id);
                return "Delete Success";
            }else{
                return "Delete Failed";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "Delete Failed";
        }
    }

    public byte[] exportJasperPdf(Long id){
        try{
            String jasperFileName = "TravelExpenseJasper.jasper";
//            JSONObject jsonObject = new JSONObject(json);
//            TravelExpense travelExpense = this.travelExpenseRepository.findOne(jsonObject.getLong("travelExpenseId"));
            TravelExpense travelExpense = this.travelExpenseRepository.findOne(id);
            log.info("approveMapFlow = {}",travelExpense.getApproveMapFlow().getApv1Emp().getEmpName());

//          travelExpense.getTravelExpenseDetails().size();
            BigDecimal expenseResult = this.travelExpenseDetailRepository.getExpenseByTravelExpense(travelExpense);
            log.info("ExpenseResult  = {}",expenseResult);
            BigDecimal expWayExpenseResult = this.travelExpenseDetailRepository.getExpWayExpenseByTravelExpense(travelExpense);
            log.info("ExpWayExpense Result  = {}",expWayExpenseResult);


            List<JasperPrint> jasperPrints = new ArrayList<>();
            Map<String,Object> map = new HashMap<>();
            map.put("expenseResult",expenseResult);
            map.put("expWayExpenseResult",expWayExpenseResult);
            if(travelExpense != null){
                //JasperPrint jasperPrint = AbstractReportJasperPDF.exportReport(jasperFileName, Arrays.asList(travelExpense), map);
                JasperPrint jasperPrint = AbstractReportJasperPDF.exportReport(jasperFileName, Arrays.asList(travelExpense),map);
                jasperPrints.add(jasperPrint);
                byte[] b = generateReportBOJ5(jasperPrints);

                return b;
            }else {
                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public byte[] generateReportBOJ5(List<JasperPrint> jasperPrintList)  throws JRException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        JRPdfExporter pdfExporter = new JRPdfExporter();
        pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jasperPrintList);
        pdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
        pdfExporter.exportReport();
        return baos.toByteArray();
    }
}
