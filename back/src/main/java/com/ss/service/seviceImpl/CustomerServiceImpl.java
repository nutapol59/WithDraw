package com.ss.service.seviceImpl;

import com.ss.domain.Customer;
import com.ss.repository.CustomerRepository;
import com.ss.service.CustomerService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private  CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> list;
        try{
            list =  (List<Customer>)this.customerRepository.findAll();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String addCustomer(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            Customer customer = new Customer();
            customer.setActive(jsonObject.getInt("active"));
            customer.setCode(jsonObject.getString("code"));
            customer.setName(jsonObject.getString("name"));
            customer.setAddress(jsonObject.getString("address"));
            this.customerRepository.save(customer);
            return "Save Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Save Failed";
        }
    }

    @Override
    public String updateCustomer(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            Long id = jsonObject.getLong("id");
            Customer customer = this.customerRepository.findOne(id);
            customer.setCode(jsonObject.getString("code"));
            customer.setName(jsonObject.getString("name"));
            customer.setActive(jsonObject.getInt("active"));
            customer.setAddress(jsonObject.getString("address"));
            this.customerRepository.save(customer);

            return "Update Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Update Failed";
        }
    }

    @Override
    public String deleteCustomer(Long id) {
        try{
            Customer customer = this.customerRepository.findOne(id);
            log.info("================DELETE customer IMPL===================");
            if (customer != null) {
                this.customerRepository.delete(id);
                return "Delete Success";
            }else {
                return "Delete Failed";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
    }
}
