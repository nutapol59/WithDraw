package com.ss.repository;


import com.ss.domain.TravelExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TravelExpenseRepository extends CrudRepository<TravelExpense,Long>,JpaRepository<TravelExpense, Long> {

    @Query("select max(t.documentNumber) from TravelExpense t  ")
    String findAllCustom();

}
