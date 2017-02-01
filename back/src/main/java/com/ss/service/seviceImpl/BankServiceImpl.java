package com.ss.service.seviceImpl;

import com.ss.domain.Bank;
import com.ss.repository.BankRepository;
import com.ss.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    private BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public List<Bank> getBanks() {
        return null;
    }

    @Override
    public String addBank(String json) {
        return null;
    }

    @Override
    public String updateBank(String json) {
        return null;
    }

    @Override
    public String deleteBank(Long id) {
        return null;
    }
}
