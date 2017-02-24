package com.ss.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.util.*;
import java.math.BigDecimal;

public class TravelExpenseFactory {

    public static List<TravelExpense> createJasperDataSource(){

        AppMenu appMenu = new AppMenu();
        AppRole appRole = new AppRole();
        AppRoleMenu appRoleMenu = new AppRoleMenu();


        Company company = new Company();
        company.setId(new Long(1));
        company.setVersion(new Long(0));
        company.setCode("c1");
        company.setName("Soft Plus Technology");
        company.setActive(1);

        Customer customer = new Customer();
        customer.setId(new Long(1));
        customer.setVersion(new Long(0));
        customer.setCode("c110");
        customer.setName("BigC");
        customer.setActive(1);

        Department department = new Department();
        department.setId(new Long(1));
        department.setVersion(new Long(0));
        department.setCode("d1");
        department.setName("Engineer");
        department.setActive(1);
        
        AppUser appUser = new AppUser();
        appUser.setId(new Long(1)); 
        appUser.setVersion(new Long(0));
        appUser.setEmpCode("e1");
        appUser.setEmpName("ทิตยชัย");
        appUser.setEmpLastName("วัฒนกิจพานิช");
        appUser.setEmpAddress("4/8 ซอยเลี่ยงเมือง3 ถนนเลี่ยงเมือง ตำบลในเมือง อำเภอเมือง จังหวัดอุบลราชธานี 34000");
        appUser.setPersonalId("1349900669563");
        appUser.setTel("0875466189");
        appUser.setEmail("nutapol49@hotmail.com");
        appUser.setLdapUserName("nutapol59");
        appUser.setPassword("098652484");
        appUser.setDepartment(department);
        appUser.setCompany(company);

        ApproveMapFlow approveMapFlow = new ApproveMapFlow();
        approveMapFlow.setApv1Emp(appUser);

        AppUserRole appUserRole = new AppUserRole();
        Bank bank = new Bank();
        bank.setId(new Long(1));
        bank.setVersion(new Long(0));
        bank.setCode("b001");
        bank.setName("ธนาคารไทยพาณิชย์");
        bank.setActive(1);

        
        DocumentApprove documentApprove = new DocumentApprove();
        DocumentMaster documentMaster = new DocumentMaster();


        

        TravelExpenseDetail travelExpenseDetail = new TravelExpenseDetail();
        TravelExpense travelExpense = new TravelExpense();
        travelExpenseDetail.setId(new Long(1));
        travelExpenseDetail.setVersion(new Long(0));
        travelExpenseDetail.setTravelDate(new Date());
        travelExpenseDetail.setCustomer(customer);
        travelExpenseDetail.setTravelFrom("SoftPlus Technology");
        travelExpenseDetail.setTravelTo("BigC SuperCenter");
        travelExpenseDetail.setExpense(new BigDecimal(400));
        travelExpenseDetail.setExpWayExpense(new BigDecimal(600));
        travelExpenseDetail.setExpenseSubSummary(new BigDecimal(1000));
        travelExpenseDetail.setComment("โดนตำรวจจับเพราะชับเร็ว");
        travelExpenseDetail.setTravelExpense(travelExpense);

        TravelExpenseDetail travelExpenseDetail1 = new TravelExpenseDetail();
        travelExpenseDetail1.setId(new Long(2));
        travelExpenseDetail1.setVersion(new Long(0));
        travelExpenseDetail1.setTravelDate(new Date());
        travelExpenseDetail1.setCustomer(customer);
        travelExpenseDetail1.setTravelFrom("Test");
        travelExpenseDetail1.setTravelTo("Testss");
        travelExpenseDetail1.setExpense(new BigDecimal(600 ));
        travelExpenseDetail1.setExpWayExpense(new BigDecimal(1500));
        travelExpenseDetail1.setExpenseSubSummary(new BigDecimal(3000));
        travelExpenseDetail1.setComment("Nooooo");
        travelExpenseDetail1.setTravelExpense(travelExpense);



        travelExpense.setId(new Long(1));
        travelExpense.setVersion(new Long(0));
        travelExpense.setEmployee(appUser);
        travelExpense.setComment("ชำระค่าเดินทาง");
        travelExpense.setCompany(company);
        travelExpense.setDepartment(department);
        travelExpense.setCash(1);
        travelExpense.setChequeNumber("cheScB9934244");
        travelExpense.setChequeBank(bank);
        travelExpense.setApproveMapFlow(approveMapFlow);
        travelExpense.setExpenseSummary(new BigDecimal(40000));

        Set<TravelExpenseDetail> travelExpenseDetails = new HashSet();
        travelExpenseDetails.add(travelExpenseDetail);
        travelExpenseDetails.add(travelExpenseDetail1);
        travelExpense.setTravelExpenseDetails(travelExpenseDetails);

        return Arrays.asList(travelExpense);
    }
}
