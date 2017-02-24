package com.ss.service;


import com.ss.domain.TravelExpenseDetail;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.InputStream;
import java.util.List;

public interface TravelExpenseDetailService {
    List<TravelExpenseDetail> getTravelExpenseDetails();
    List<TravelExpenseDetail> getTravelExpenseDetailsByTravelExpenseId(Long travelExpenseId);
    String addTravelExpenseDetail(TravelExpenseDetail formData, MultipartHttpServletRequest multipartHttpServletRequest);
    String updateTravelExpenseDetail(TravelExpenseDetail formData, MultipartHttpServletRequest multipartHttpServletRequest);
    String deleteTravelExpenseDetail(Long id);
    InputStream showPreview(Long travelExpenseDetailId, Integer filenumber);

}
