package com.ss.repository;


import com.ss.domain.TravelExpense;
import com.ss.domain.TravelExpenseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface TravelExpenseDetailRepository extends CrudRepository<TravelExpenseDetail,Long>,JpaRepository<TravelExpenseDetail,Long> {
    @Query("select t.travelExpenseDetails from TravelExpense t where t.id = ?1")
    List<TravelExpenseDetail> getTravelExpenseDetailsByTravelExpenseId(Long travelExpenseId);

    @Query("select sum(t.expense) from TravelExpenseDetail t where t.travelExpense = ?1")
    BigDecimal getExpenseByTravelExpense(TravelExpense travelExpenseId);

    @Query("select sum(t.expWayExpense) from TravelExpenseDetail t where t.travelExpense = ?1")
    BigDecimal getExpWayExpenseByTravelExpense(TravelExpense travelExpenseId);
}
