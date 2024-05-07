package com.web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.entity.BankAccount;
import com.web.service.BankAccountService;

@Controller
public class BankController 
{
	@Autowired
	private BankAccountService accountService;
	
	@RequestMapping("/")
	public String homePage() 
	{
		return "home"; // JSP file name TO DISPLAY THE BANK DETAILS 
	}
	
	@RequestMapping("/addAccount")  //URL here ADD ACCOUNT PURPOSE ONLY BY CALLING THE USING THE URL NAME 
	public String addAccountdetails(ModelMap model) 
	{
		return "addAccountDetails";  //JSP FILE FOR ADDING NEW ACCOUNT DETAILS
	}
	@RequestMapping("/registerAccount")  //URL FOR SAVE THE RECORDS  IN THE  addAccountDetails JSP FILE 	
	public String saveAccountDetails(BankAccount bankAccount)
	{
		accountService.saveBankDetails(bankAccount);
		return "success";    //FOR SHOWING DATA SUCCESSFULLY OR NOT PURPOSE 
	}
	
	
	@RequestMapping("/checkBalance")  //URL FROM HOME PAGE TO RENDER VALUES INTO THE  checkAccount on JSP file  
	public String cheackBalance(ModelMap model)
	{
		return "checkAccount";    //JSP FILE CREATING FOR INPUT DATA SENDING TO THE FORM ELEMEMTS TO THE BALANCE FORM 
	}
	@RequestMapping("/validateAccount") //THIS URL IS USED IN THE checkAccount for render values INTO FORM PAGE AS ACTION IN THE PAGE
	public String validateAccountDetails(BankAccount bankAccount,ModelMap model)
	{
		BankAccount bankAccount1 = accountService.getbankDetails(bankAccount.getAccountNumber(), bankAccount.getName(), bankAccount.getPassword());
	String name = bankAccount.getName();
	if (bankAccount1 != null)
	{
		model.put("name", name);
		model.put("details", bankAccount1);
		return "viewAccountDetails"; //JSP FILE FOR THE VALID DETAILS FOR THE ACCOUNT 
	}
	else 
	{
		model.put("error", "INVALID ACCOUNT DETAILS");
		return "errorPage";  // JSP FILE FOR THE INVALID CREDENTIAL PURPOSE ONLY 
	}
} 
	
	@RequestMapping("/depositAmount")    // URL IT USED TO SEND THE VALUES TO THE HOME PAGE WEB HAVE THIS LINK URL 
	public String depositForm() 
	{
		return "depositBalance"; //JSP FILE NAME IT SI USED FOR THE RENDERING THE VALUES 
	}
	@RequestMapping("/depositBalance") // using this URL we are calling in the depositAmount jsp file 
	public String depositBalance(BankAccount bankAccount,ModelMap model)
	{
		double depositAmount=bankAccount.getAmount();  // we are getting amount here only
		double incrementBalance =accountService.deposit(bankAccount.getAccountNumber(), bankAccount.getName(),bankAccount.getPassword(), bankAccount.getAmount());
		double previousAmount=incrementBalance-depositAmount;
		
		model.put("previousAmount", previousAmount);
		model.put("depositAmount", depositAmount);
		model.put("incrementBalance", incrementBalance);
		return "updateAfterDeposit";//JSP FILE AFTER DEPOSIT OPARATION COMPLITION THAT TIME 
	}
	
	
	@RequestMapping("/withdrawBalance")   // URL FROM HOME PAGE 
	public String withdrawform() 
	{
		return "withdrawForm";			//JSP FILE TO CONFIGURE withdrawAmount in withdrawForm
	}
	@RequestMapping("/withdrawAmount")   //IN withdrawForm CONFIGURE ACTION AS withdrawAmount IT CONTAINS SOME WEB DATA 
	public String withdrawBalance(BankAccount bankAccount,ModelMap model) 
	{
		double withdrawAmount = bankAccount.getAmount();
		double decrementBalance = accountService.withdraw(bankAccount.getAccountNumber(), bankAccount.getName(), bankAccount.getPassword(), bankAccount.getAmount());
		
		double previousAmount = decrementBalance+withdrawAmount;
		model.put("previousAmount", previousAmount);
		model.put("withdrawAmount", withdrawAmount);
		model.put("decrementBalance", decrementBalance);
		return "updateAfterWithdraw"; //AFTER WITH DRAW SUCCESSFULL WHAT IS THE  PREVIOUS AMOUNT WHAT IS CHNAGE AFTER WITHDRAW IT SHOWS 
	}
	
	
	@RequestMapping("/transferBalance")  // URL USED  FOR THE RENDER TO HOME PAGE CONFIGURE THIS URL AND RENDER RESPONSE RELATED JSP FILE 
	public String transferForm() 
	{
		return "transferForm";  // IN THIS JSP FILE WE ARE CONFIGURE BELLOW URL  transferForm <--------- transferFunds
	 }
	
	@RequestMapping("/transferFunds")  //configure this URL IN -----------> transferForm ONTHIS JSP FILE 
	public String transferBalance(BankAccount bankAccount, ModelMap model) 
	{
	    BankAccount fromAccount = accountService.getbankDetails(
	            bankAccount.getAccountNumber(),      //DATA FROM THE WEB 
	            bankAccount.getName(),
	            bankAccount.getPassword());

	    if (fromAccount != null)          // SENDER ACCOUNT NOTHING BUT FIRST ACCOUNT 
	    {
	        long fromAccountNumber = fromAccount.getAccountNumber();
	        double fromAccountBalance = fromAccount.getAmount();
	        double fromTransferAmount = bankAccount.getAmount();
	        double fromCurrentAmount = fromAccountBalance - fromTransferAmount;

	        Long toAccountNumber = bankAccount.getTargetAccountNumber();

	        BankAccount toAccount = accountService.getTargetAccountBankDetails(
	                bankAccount.getTargetAccountNumber());
	        if (toAccount != null)             // RECIVER ACCOUNT NOTHING BUT SECOND ACCOUNT 
	        {
	            double targetAccountBalance = toAccount.getAmount();

	            double updateTransferAmount = accountService.transfer(
	                    bankAccount.getAccountNumber(),
	                    bankAccount.getName(),
	                    bankAccount.getPassword(),
	                    bankAccount.getAccountNumber(),       // updateTransferAmount store record and to send the to account 
	                    bankAccount.getAmount()
	            );

	            // FROM ACCOUNT DETAILS
	            model.put("fromAccountNumber", fromAccountNumber);
	            model.put("fromAccountBalance", fromAccountBalance);
	            model.put("fromTransferAmount", fromTransferAmount);
	            model.put("fromCurrentAmount", fromCurrentAmount);
	            // TO ACCOUNT DETAILS
	            model.put("toAccountNumber", toAccountNumber);
	            model.put("targetAccountBalance", targetAccountBalance);
	            model.put("updateTransferAmount", updateTransferAmount);
	            
	            return "updateAfterTransfer";   // JSP file for update after transfer 
	        }
	    }
		return "transferError";   //JSP FILE FOR ANY ERROR OCCURED 
	}
	@RequestMapping("/close")     // URL USED  FOR THE RENDER TO HOME PAGE CONFIGURE THIS URL AND RENDER RESPONSE RELATED JSP FILE 
	public String closeForm() 
	{
		return "closeForm";   // IN THIS JSP FILE WE ARE CONFIGURE BELLOW URL  closeForm <--------- closeAccount
	}
	@RequestMapping("/closeAccount")  //^^^^<-------------
	public String closeAccountDetails(BankAccount  bankAccount, ModelMap map) 
	{
		BankAccount account1 = accountService.getbankDetails(
				bankAccount.getAccountNumber(),
				bankAccount.getName(),
				bankAccount.getPassword());
			long accountNumber = account1.getAccountNumber();
			String name = account1.getName();
		map.put("accountNumber", accountNumber);
		map.put("name", name);

		return "closeAccount";  // JSP FILE FOR THE CLOSE ACCOUNT 
	}
}
	   
