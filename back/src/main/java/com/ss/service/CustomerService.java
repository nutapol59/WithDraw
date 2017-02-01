package com.ss.service;


import com.ss.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    String addCustomer(String json);
    String updateCustomer(String json);
    String deleteCustomer(Long id);
}
