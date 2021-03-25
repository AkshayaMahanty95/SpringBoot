package com.ojas;

public class Account {

	//variable
	double accountNumber, balance;
	
	//setter and getter
	public double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	//default constructor
	public Account() {
		super();
	}
	
	//constructor
	public Account(double accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	
	
}
