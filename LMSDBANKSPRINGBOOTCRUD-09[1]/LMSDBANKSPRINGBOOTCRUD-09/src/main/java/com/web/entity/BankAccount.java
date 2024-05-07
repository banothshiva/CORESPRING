package com.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bank")
public class BankAccount 
{
	@Id
	private Long accountNumber;
	private String name;
	private String password;
	private double amount;
	private String address;
	private String mobileNumber;
	private Long targetAccountNumber;

	// PDC
	public BankAccount() {
		super();
	}

	// PPC
	public BankAccount(Long accountNumber, String name, String password, double amount, String address,
			String mobileNumber) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.amount = amount;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}

	// PGM + PSM
	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getTargetAccountNumber() {
		return targetAccountNumber;
	}

	public void setTargetAccountNumber(Long targetAccountNumber) {
		this.targetAccountNumber = targetAccountNumber;
	}

	

	 
}
