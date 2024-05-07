package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.BankAccount;
import com.web.repo.BankAccountRepository;
@Service
public class BankAccountServiceImp implements BankAccountService {

	@Autowired
	public  BankAccountRepository accountRepository;
	@Override
	public BankAccount saveBankDetails(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		return accountRepository.save(bankAccount);
	}

	@Override
	public BankAccount getBankDetails(long accountNumber, String name, String password) {
		// TODO Auto-generated method stub
        return accountRepository.findByAccountNumberAndNameAndPassword(accountNumber, name, password);
	}

	@Override
	public double deposit(long accountNumber, String name, String password, double amount) {
        BankAccount bankAccount = accountRepository.findByAccountNumberAndNameAndPassword(accountNumber, name, password);
        if(bankAccount != null)
        {
        	double incrBalance = bankAccount.getAmount() + amount;
        	bankAccount.setAmount(incrBalance);
        	accountRepository.save(bankAccount);
        	return incrBalance;
        }
        return -1;
	}

	@Override
	public double withdraw(Long accountNumber, String name, String password, double amount) 
	{
		BankAccount bankAccount = accountRepository.findByAccountNumberAndNameAndPassword(accountNumber,name,password);
		if(bankAccount != null)
		{
			if(bankAccount.getAmount() > amount)
			{
				double decrBalance = bankAccount.getAmount() - amount;
				bankAccount.setAmount(decrBalance);
				accountRepository.save(bankAccount);
				return decrBalance;
			}
		}
		return -1;
	}
	@Override
	public BankAccount getTargAccountBankDetails(Long targetAccountNumber) {
		BankAccount bankAccount = accountRepository.findByAccountNumber(targetAccountNumber);
		return bankAccount;
	}

	@Override
	public double transfer(long fromAccountNumber, String name, String password, long toAccountNumber, double amount) {
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
	private double depositAmount(long toAccountNumber, double amount) {
		BankAccount bankAccount = accountRepository.findByAccountNumber(toAccountNumber);
		if(bankAccount != null)
		{
			double incrBalance = bankAccount.getAmount() + amount;
        	bankAccount.setAmount(incrBalance);
        	accountRepository.save(bankAccount);
        	return incrBalance;
        }
		return -1;
	}
	


	

}
