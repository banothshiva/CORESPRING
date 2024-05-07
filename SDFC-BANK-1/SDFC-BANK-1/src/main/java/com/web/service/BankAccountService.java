package com.web.service;

import com.web.entity.BankAccount;

public interface BankAccountService {
	public BankAccount saveBankDetails(BankAccount bankAccount);
	public BankAccount getbankDetails (long accountNumber , String name , String password);
	public double deposit(long accountNumber , String name , String password,double amount);
	public double withdraw(long accountNumber , String name , String password,double amount);
	public  double transfer(long fromAccountNumber,String name,String password,long targetAccountNumber, double amount);
	public BankAccount getTargetAccountBankDetails(Long targetAccountNumber);
	public double depositAmount(long toAccountNumber , double amount);


}
