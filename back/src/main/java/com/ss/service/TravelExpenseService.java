package com.ss.service;

import com.ss.domain.TravelExpense;

import java.util.List;

public interface TravelExpenseService {
     List<TravelExpense> getTravelExpenses();
     List<TravelExpense> getTravelExpensesByAppUserId(Long appUserId);
     Long addTravelExpense(String json);
     Long updateTravelExpense(String json);
     String deleteTravelExpense(Long id);
}
