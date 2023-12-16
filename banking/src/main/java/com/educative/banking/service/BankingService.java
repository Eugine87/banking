package com.educative.banking.service;

import com.educative.banking.model.Banking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.educative.banking.repository.BankingRepo;
import java.util.Map;
import java.util.Optional;

@Service
public class BankingService {

    @Autowired
    BankingRepo bankingRepo;
    
    

    public void putMoney(Long id, double amount) {
        Optional<Banking> optionalLesson = bankingRepo.findById(id);
        Banking banking = optionalLesson.get();
        banking.setSum(banking.getSum()+amount);
        bankingRepo.save(banking);
    }

    public Banking createBanking(Banking banking) {
        return bankingRepo.save(banking);
    }

    
    public Optional<Banking> getBalance(Long id) {
        return bankingRepo.findById(id);
    }

    public void getMoney(Long id, double amount) {
        Optional<Banking> optionalLesson = bankingRepo.findById(id);
        Banking banking = optionalLesson.get();
        banking.setSum(banking.getSum()-amount);
        bankingRepo.save(banking);
    }

    

}
