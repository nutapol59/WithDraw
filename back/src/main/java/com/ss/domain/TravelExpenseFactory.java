package com.ss.domain;


import java.util.Arrays;
import java.util.List;

public class TravelExpenseFactory {
    public List<String> createJasperDataSource(){


        TravelExpense travelExpense = new TravelExpense();

        TravelExpenseDetail travelExpenseDetail = new TravelExpenseDetail();

        Customer customer = new Customer();

        Company company = new Company();

        Department department = new Department();

        Bank bank = new Bank();

        AppUser appUser = new AppUser();

        ApproveMapFlow approveMapFlow = new ApproveMapFlow();

        return Arrays.asList();
    }
}
