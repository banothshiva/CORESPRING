package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.entity.BankAccount;
import com.web.service.BankAccountService;

@Controller
public class BankController {
	@Autowired
	private BankAccountService accountService;
	
	@RequestMapping("/")
	public String homePage()
	{
		return "home";
	}
	@RequestMapping("/addAccount")
	public String addAccountDetails(ModelMap model)
	{
		return "addAccountDetails";	
	}
	@RequestMapping("/registerAccount")
	public String saveAccountDetails(BankAccount bankAccount) 
	{
		accountService.saveBankDetails(bankAccount);
		return "success";	
	}
	@RequestMapping("/checkBalance")
	public String checkBalance(ModelMap model)
	{
		return "checkAccount";
	}
	@RequestMapping("/validateAccount")
	public String validateAccountDetails(BankAccount bankAccount,ModelMap model)
	{
		BankAccount bankAccount1 = accountService.getBankDetails(
				bankAccount.getAccountNumber(),
				bankAccount.getName(),
				bankAccount.getPassword());
		String name = bankAccount.getName();
		if(bankAccount1 != null)
		{
			model.put("name", name);
			model.put("details", bankAccount1);
			return "viewAccountDetails";
		}
		else 
		{
			model.put("error","INVALID ACCOUNT DETAILS");
			return "errorPage";
			
		}	
	}
	@RequestMapping("/depositAmount")
	public String depositForm()
	{
		return "depositBalance";
	}
	@RequestMapping("/depositBalance")
	public String depositBalance(BankAccount bankAccount,ModelMap model)
	{
		double depositAmount = bankAccount.getAmount();
		double incrBalance = accountService.deposit(
				bankAccount.getAccountNumber(),
				bankAccount.getName(),
				bankAccount.getPassword(),
				bankAccount.getAmount());
		double previousAmount = incrBalance - depositAmount;
		model.put("previousAmount", previousAmount);
		model.put("depositAmount", depositAmount);
		model.put("incrBalance", incrBalance);
		return "updatedAfterDeposit";
	}
	@RequestMapping("/withdrawBalance")
	public String withdrawForm()
	{
		return "withdrawForm";
	}
	@RequestMapping("/withdrawAmount")
	public String withdrawBalance(BankAccount bankAccount ,ModelMap model)
	{
		double withdrawAmount = bankAccount.getAmount();
		double decrBalance = accountService.withdraw(
				bankAccount.getAccountNumber(),
				bankAccount.getName(),
				bankAccount.getPassword(),
				bankAccount.getAmount());
		double previousAmount = decrBalance + withdrawAmount;
		model.put("previousAmount", previousAmount);
		model.put("withdrawAmount", withdrawAmount);
		model.put("decrBalance", decrBalance);
		return "updatedAfterWithdraw";
	}
	
	@RequestMapping("/transferBalance")
	public String transferForm()
	{
		return "transferForm";
	}
	@RequestMapping("/transferFunds")
	public String transferBalance(BankAccount bankAccount, ModelMap model)
	{
		BankAccount bankAccount2 = accountService.getBankDetails(
				bankAccount.getAccountNumber(),
				bankAccount.getName(),
				bankAccount.getPassword());
		Long fromAccountNumber = bankAccount.getAccountNumber();
		double fromAccountBalance = bankAccount2.getAmount();
		double fromTransferAmount = bankAccount.getAmount();
		double fromCurrentAmount = fromAccountBalance - fromTransferAmount;
		
		Long toAccountNumber = bankAccount.getTargetAccountNumber();
		BankAccount bankAccount3 = accountService.getTargAccountBankDetails(bankAccount.getTargetAccountNumber());
		
		if(bankAccount3 == null)
		{
			return "transferError";
		}
		
		double targetAccountBalance = bankAccount3.getAmount();
		
		double updateTransferAmount = accountService.transfer(
				bankAccount.getAccountNumber(),
				bankAccount.getName(),
				bankAccount.getPassword(),
				bankAccount.getTargetAccountNumber(),
				bankAccount.getAmount());
		
		//from account details
		model.put("fromAccountNumber", fromAccountNumber);
		model.put("fromAccountBalance", fromAccountBalance);
		model.put("fromTransferAmount", fromTransferAmount);
		model.put("fromCurrentAmount", fromCurrentAmount);
		
		// to account details
		model.put("toAccountNumber", toAccountNumber);
		model.put("targetAccountBalance", targetAccountBalance);
		model.put("updateTransferAmount", updateTransferAmount);
		return "updatedAfterTransfer";
	}
	@RequestMapping("/close")
	public String closeForm()
	{
		return "closeForm";
	}
	@RequestMapping("/closeAccount")
	public String closeAccountDetails(BankAccount bankAccount,ModelMap model)
	{
		BankAccount bankAccount1 = accountService.getBankDetails(
				bankAccount.getAccountNumber(),
				bankAccount.getName(),
				bankAccount.getPassword());
		Long accountNumber = bankAccount1.getAccountNumber();
		String name = bankAccount1.getName();
		model.put("accountNumber", accountNumber);
		model.put("name", name);
		return "closeAccount";
	}
}
