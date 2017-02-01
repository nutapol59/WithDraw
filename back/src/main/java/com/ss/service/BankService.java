package com.ss.service;


import com.ss.domain.Bank;

import java.util.List;

public interface BankService {
    List<Bank> getBanks();
    String addBank(String json);
    String updateBank(String json);
    String deleteBank(Long id);
}
