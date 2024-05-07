package com.web.service;

import com.web.entity.BankAccount;

public interface BankAccountService 
{
	public BankAccount saveBankDetails(BankAccount bankAccount);
	public BankAccount getBankDetails(long accountNumber, String name, String password);
	public  double deposit(long accountNumber,String name,String password, double amount);
//	public  double withdraw(long accountNumber, double amount);
	public  double transfer(long fromAccountNumber,String name,String password, long toAccountNumber, double amount);
	public double withdraw(Long accountNumber, String name, String password, double amount);
	public BankAccount getTargAccountBankDetails(Long targetAccountNumber);

}
