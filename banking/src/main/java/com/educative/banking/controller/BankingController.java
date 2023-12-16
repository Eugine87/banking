package com.educative.banking.controller;

import com.educative.banking.model.Banking;
import com.educative.banking.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/banking")
public class BankingController {

    @Autowired
    BankingService bankingService;

    @PostMapping("/createBanking")
    public Banking createBanking(@RequestBody Banking banking) {
        return bankingService.createBanking(banking);
    }
    
    @PostMapping("/put/{id}")
    public String putMoneу(@PathVariable Long id, Double amount) {
        bankingService.putMoney(id, amount);
        return "success";
    }
    @PostMapping("/get/{id}")
    public String getMoneу(@PathVariable Long id, Double amount) {
        bankingService.getMoney(id,amount);
        return "success";
        
    }
    
    @GetMapping("/{id}")
    public Banking getBalance(@PathVariable(value="id")Long id ) {
        return bankingService.getBalance(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
