package com.ss.service;


import com.ss.domain.TravelExpenseDetail;

import java.util.List;

public interface TravelExpenseDetailService {
    List<TravelExpenseDetail> getTravelExpenseDetails();
    String addTravelExpenseDetail(String json);
    String updateTravelExpenseDetail(String json);
    String deleteTravelExpenseDetail(Long id);
}
