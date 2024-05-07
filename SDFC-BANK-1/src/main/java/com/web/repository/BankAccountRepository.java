package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.BankAccount;
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

	BankAccount findByAccountNumberAndNameAndPassword(long accountNumber, String name, String password);

	BankAccount findByAccountNumber(long targetAccountNumber);


}
