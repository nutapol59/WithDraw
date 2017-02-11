package com.ss.repository;


import com.ss.domain.ApproveMapFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ApproveMapFlowRepository extends CrudRepository<ApproveMapFlow,Long>,JpaRepository<ApproveMapFlow,Long>{

    @Query("select approveMapFlow from ApproveMapFlow approveMapFlow where approveMapFlow.employee.id = ?1")
    ApproveMapFlow findApproveMapFlowByAppUserId(Long id);
}
