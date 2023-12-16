package com.educative.banking.repository;

import com.educative.banking.model.Banking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingRepo extends JpaRepository<Banking, Long> {
 
    
}
