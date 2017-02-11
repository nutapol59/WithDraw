package com.ss.service;

import com.ss.domain.TravelExpense;

import java.util.List;

public interface TravelExpenseService {
     List<TravelExpense> getTravelExpenses();
     Long addTravelExpense(String json);
     String updateTravelExpense(String json);
     String deleteTravelExpense(Long id);
}
