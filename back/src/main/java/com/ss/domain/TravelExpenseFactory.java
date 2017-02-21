package com.ss.domain;


import com.ss.repository.TravelExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;


public class TravelExpenseFactory {


    public TravelExpenseFactory() {
    }

    public List<TravelExpense> createJasperDataSource(){

        AppMenu appMenu = new AppMenu();
        AppRole appRole = new AppRole();
        AppRoleMenu appRoleMenu = new AppRoleMenu();
        ApproveMapFlow approveMapFlow = new ApproveMapFlow();
        AppUser appUser = new AppUser();
        AppUserRole appUserRole = new AppUserRole();
        Bank bank = new Bank();
        Company company = new Company();
        Customer customer = new Customer();
        Department department = new Department();
        DocumentApprove documentApprove = new DocumentApprove();
        DocumentMaster documentMaster = new DocumentMaster();
        TravelExpense travelExpense = new TravelExpense();
        TravelExpenseDetail travelExpenseDetail = new TravelExpenseDetail();


        return Arrays.asList(travelExpense);
    }
}
