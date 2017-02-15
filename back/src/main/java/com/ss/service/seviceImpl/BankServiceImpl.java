package com.ss.service.seviceImpl;

import com.ss.domain.Bank;
import com.ss.repository.BankRepository;
import com.ss.service.BankService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    private BankRepository bankRepository;
    private static final Logger log = LoggerFactory.getLogger(BankServiceImpl.class);
    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public List<Bank> getBanks() {
        List<Bank> list;

        try{
            list =  (List<Bank>)this.bankRepository.findAll();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
//        for (Company company : this.companyRepository.findAll()) {
//            list.add(company);
//        }

    }

    @Override
    public String addBank(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            Bank bank = new Bank();
            bank.setActive(jsonObject.getInt("active"));
            bank.setCode(jsonObject.getString("code"));
            bank.setName(jsonObject.getString("name"));
            this.bankRepository.save(bank);

            return "Save Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Save Failed";
        }

    }

    @Override
    public String updateBank(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            Long id = jsonObject.getLong("id");
            Bank bank = this.bankRepository.findOne(id);
            bank.setCode(jsonObject.getString("code"));
            bank.setName(jsonObject.getString("name"));
            bank.setActive(jsonObject.getInt("active"));
            this.bankRepository.save(bank);

            return "Update Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Update Failed";
        }
    }

    @Override
    public String deleteBank(Long id) {
        try{
            Bank bank = this.bankRepository.findOne(id);
            log.info("================DELETE bank IMPL===================");
            if (bank != null) {
                this.bankRepository.delete(id);
                return "Delete Success";
            }else {
                return "Delete Failed";
                }

        }catch (Exception e){
            e.printStackTrace();
            return "Error";
        }

    }
}
