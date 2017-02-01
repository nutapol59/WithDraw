package com.ss.repository;

import com.ss.domain.Department;
import org.springframework.data.repository.CrudRepository;


public interface DepartmentRepository extends CrudRepository<Department,Long> {
}
