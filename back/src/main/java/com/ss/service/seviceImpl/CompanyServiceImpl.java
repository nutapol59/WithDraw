package com.ss.service.seviceImpl;


import com.ss.domain.Company;
import com.ss.repository.CompanyRepository;
import com.ss.service.CompanyService;
import flexjson.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl  implements CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getCompanies() {
        List<Company> list = new ArrayList<>();
        for (Company company : this.companyRepository.findAll()) {
            list.add(company);
        }

        return list;
    }

    @Override
    public String addCompany(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            Company company = new Company(null);
            company.setActive(jsonObject.getInt("active"));
            company.setCode(jsonObject.getString("code"));
            company.setName(jsonObject.getString("name"));
            this.companyRepository.save(company);

            return "Save Success";
        } catch (Exception e) {
            return "Save Failed";
        }

    }

    @Override
    public String updateCompany(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            Long id = jsonObject.getLong("id");
            Company company = this.companyRepository.findOne(id);
            company.setCode(jsonObject.getString("code"));
            company.setName(jsonObject.getString("name"));
            company.setActive(jsonObject.getInt("active"));
            this.companyRepository.save(company);

            return "Update Success";
        } catch (Exception e) {
            return "Update Failed";
        }
    }

    @Override
    public String deleteCompany(Long id) {
        Company company = this.companyRepository.findOne(id);
        if (company != null) {
            if (company.getDepartments().size() > 0) {
                return "Have Department";
            } else {
                this.companyRepository.delete(id);
                return "Delete Success";
            }
        } else {
            return "Not Found Company";
        }
    }

}