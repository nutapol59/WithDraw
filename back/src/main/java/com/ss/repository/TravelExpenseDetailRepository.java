package com.ss.repository;


import com.ss.domain.TravelExpenseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TravelExpenseDetailRepository extends CrudRepository<TravelExpenseDetail,Long>,JpaRepository<TravelExpenseDetail,Long> {
}
