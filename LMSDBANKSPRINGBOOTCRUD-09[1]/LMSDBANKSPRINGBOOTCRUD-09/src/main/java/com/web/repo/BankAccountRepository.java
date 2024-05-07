package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

	BankAccount findByAccountNumberAndNameAndPassword(long accountNumber, String name, String password);

	BankAccount findByAccountNumber(Long targetAccountNumber);


}
