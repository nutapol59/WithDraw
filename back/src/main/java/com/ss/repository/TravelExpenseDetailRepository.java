package com.ss.repository;


import com.ss.domain.TravelExpenseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TravelExpenseDetailRepository extends CrudRepository<TravelExpenseDetail,Long>,JpaRepository<TravelExpenseDetail,Long> {
    @Query("select t.travelExpenseDetails from TravelExpense t where t.id = ?1")
    List<TravelExpenseDetail> getTravelExpenseDetailsByTravelExpenseId(Long travelExpenseId);
}
