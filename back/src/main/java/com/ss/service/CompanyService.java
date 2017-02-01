package com.ss.service;

import com.ss.domain.Company;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CompanyService  {
    List<Company> getCompanies();
    String addCompany(String json);
    String updateCompany(String json);
    String deleteCompany(Long id);

}
