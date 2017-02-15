package com.ss.service;


import com.ss.domain.ApproveMapFlow;

import java.util.List;

public interface ApproveMapFlowService {
    List<ApproveMapFlow> getApproveMapFlows();
    String addApproveMapFlow(String json);
    String updateApproveMapFlow(String json);
    String deleteApproveMapFlow(Long id);
}
