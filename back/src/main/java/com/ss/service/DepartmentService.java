package com.ss.service;

import com.ss.domain.Department;
import com.ss.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
    List<Department> getDepartments();
    String addDepartment(String json);
    String updateDepartment(String json);
    String deleteDepartment(Long id);
}
