package com.ss.service.seviceImpl;


import com.ss.domain.Company;
import com.ss.domain.Department;
import com.ss.repository.CompanyRepository;
import com.ss.repository.DepartmentRepository;
import com.ss.service.DepartmentService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private CompanyRepository companyRepository;
    private static final Logger log = LoggerFactory.getLogger("DepartmentServiceImpl.class");

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, CompanyRepository companyRepository) {
        this.departmentRepository = departmentRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Department> getDepartments() {
        List<Department> list = new ArrayList<>();
        List list1 = new ArrayList();
        try{
            log.info("==================into GET DEP IMPL================");
//            log.info("{}",this.departmentRepository.findAll());
            log.info("============end=======================");
            for(Department department :  this.departmentRepository.findAll()){
                list.add(department);
            }

//            list=(List<Department>) this.departmentRepository.findAll();
//            log.info("=============ToString=========================");
//            log.info(list.toString());
            log.info("=============End LIST list size :{}=========================",list.size());
            return list;
        }catch (Exception e){
            e.printStackTrace();
            list.clear();
            return list;
        }

    }

    @Override
    public String addDepartment(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            Long companyId = jsonObject.getLong("companyId");
            log.info("addDepartment");
            Company company = companyRepository.findOne(companyId);
            if(company != null){
                Department department = new Department();
                department.setActive(jsonObject.getInt("active"));
                department.setCode(jsonObject.getString("code"));
                department.setName(jsonObject.getString("name"));
                department.setCompany(company);
                this.departmentRepository.save(department);
                log.info("department = {}",department);
                log.info("addDepartment Success");

                return "Save Success";
            }else{
                return "Not Found Company";

            }



        } catch (Exception e) {
            e.printStackTrace();
            return "Save Failed";
        }
    }

    @Override
    public String updateDepartment(String json) {
        try {
            log.info("updateDepartmeny IMPL");
            JSONObject jsonObject = new JSONObject(json);
            Long id = jsonObject.getLong("id");
            Department department;
            department = this.departmentRepository.findOne(id);
            log.info("department = {}",this.departmentRepository.findOne(id));
            log.info("department = {}",department);
            if(department != null) {
                log.info("department not null");
                Long companyId = jsonObject.getLong("companyId");
                Company company = companyRepository.findOne(companyId);
                if (company != null) {
                    log.info("company not null");
                    department.setActive(jsonObject.getInt("active"));
                    department.setCode(jsonObject.getString("code"));
                    department.setName(jsonObject.getString("name"));
                    department.setCompany(company);
                    this.departmentRepository.save(department);
                    return "Update Success";
                } else {
                    return "Not Found Company";
                }
            }else {
                return "Update Failed";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "Update Failed";
        }
    }

    @Override
    public String deleteDepartment(Long id) {
        try {
            Department department = this.departmentRepository.findOne(id);
            if (department != null){
                this.departmentRepository.delete(id);
                return "Delete Success";
            }else
                return "Delete Failed Not Found Department";
        }catch (Exception e){
            e.printStackTrace();
            return "Delete Failed Not Found Department";
        }

    }
}
