package com.ss.service;

import com.ss.domain.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyService extends CrudRepository<Company,Long> {

    
}
