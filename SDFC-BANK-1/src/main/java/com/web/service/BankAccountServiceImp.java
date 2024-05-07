package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.BankAccount;
import com.web.repository.BankAccountRepository;
@Service
public class BankAccountServiceImp implements BankAccountService 
{
	@Autowired
	private BankAccountRepository accountRepository;

	@Override
	public BankAccount saveBankDetails(BankAccount bankAccount)
	{
		return accountRepository.save(bankAccount);
	}

	@Override
	public BankAccount getbankDetails(long accountNumber, String name, String password) {
		return accountRepository.findByAccountNumberAndNameAndPassword(accountNumber,name,password);
	}

	@Override
	public double deposit(long accountNumber, String name, String password, double amount) {
		BankAccount bankAccount = accountRepository.findByAccountNumberAndNameAndPassword(accountNumber, name, password);
			if (bankAccount != null )
			{
				double incrementBalance = bankAccount.getAmount()+amount;
				bankAccount.setAmount(incrementBalance);
				accountRepository.save(bankAccount);
				return incrementBalance;
			}
			else
			{
			return -1;
			}
	}

	@Override
	public double withdraw(long accountNumber, String name, String password, double amount) {
	BankAccount bankAccount = accountRepository.findByAccountNumberAndNameAndPassword(accountNumber, name, password);
	if (bankAccount != null)
	{
		if (bankAccount.getAmount()>amount)
		{
			double decrementBalance = bankAccount.getAmount()-amount;
			bankAccount.setAmount(decrementBalance);
			accountRepository.save(bankAccount);
			return decrementBalance;
			
		}
	
	}
	return -2;
	}
	
	@Override
	public double transfer(long fromAccountNumber, String name, String password,
			long toAccountNumber, double amount) {
		double  withdrawResult = withdraw(fromAccountNumber, name, password, amount);
		double depositResult=0.0;
		if(withdrawResult >= 0)
		{
			if(depositResult >= 0)
			{
				depositResult = depositAmount(toAccountNumber,amount);
				return depositResult;
			}
			else
			{
				depositAmount(fromAccountNumber, amount);
			}
		}
		return -5;
	}
	
	@Override
	public BankAccount getTargetAccountBankDetails(Long targetAccountNumber) {
		BankAccount bankAccount = accountRepository.findByAccountNumber(targetAccountNumber);
		
		return bankAccount ;
	}

	@Override
	public double depositAmount(long toAccountNumber, double amount)
	{
		BankAccount bankAccount = accountRepository.findByAccountNumber(toAccountNumber);
		if (bankAccount != null)
		{
			double incrementBalance = bankAccount.getAmount()+amount;
			bankAccount.setAmount(incrementBalance);
			accountRepository.save(bankAccount);
			return incrementBalance;
			
		}
		
		
		
		return -1;
	}

	
}
