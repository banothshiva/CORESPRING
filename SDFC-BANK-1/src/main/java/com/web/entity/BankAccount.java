package com.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="BA")
public class BankAccount
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountNumber;
	private String  name;
	private String  password;
	private double  amount;
	private String  address;
	private long mobileNumber;
	private Long targetAccountNumber;

	//PDC + PPC + PSM + PGM + TO-STRING 
	public BankAccount() 
	{
		super();
	}

	public BankAccount(long accountNumber, String name, String password, double amount, String address,
			long mobileNumber, Long targetAccountNumber) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.amount = amount;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.targetAccountNumber = targetAccountNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
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

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getTargetAccountNumber() {
		return targetAccountNumber;
	}

	public void setTargetAccountNumber(Long targetAccountNumber) {
		this.targetAccountNumber = targetAccountNumber;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", name=" + name + ", password=" + password + ", amount="
				+ amount + ", address=" + address + ", mobileNumber=" + mobileNumber + ", targetAccountNumber="
				+ targetAccountNumber + "]";
	}
	}
