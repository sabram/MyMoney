package com.mymoney.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

import com.domainlanguage.money.Money;

public class Account extends BaseEntity {

	public static final Currency DEFAULT_CURRENCY = Currency.getInstance("USD");
	
	private String name;
	private String shortName;
	private String accountNum;
	private String notes;
	private Money openingBalance;
	private Currency currency;
    private Set<Transaction> transactions = new HashSet<Transaction>();
	/**
	 * Fields not being stored:
	 * 		balance - calculate.
	 * Future Fields...
	 * 		String/Institution institution
	 * 		private AccountType accountType; //e.g. Cash, Bank, CreditCard
	 * 		private AccountStatus accountStatus; //impld as an Enum, e.g. Open, Closed
	 * 		private Money minBalance;
	 * 		private Money maxBalance;
	 * 		Currency
	 * 		interestRate
	 */

	public Account() {
		//opening balance defaults to zero
		openingBalance = Money.valueOf(new BigDecimal(0.0), DEFAULT_CURRENCY);
		currency = DEFAULT_CURRENCY;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Money getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(Money openingBalance) {
		this.openingBalance = openingBalance;
	}
	public Currency getCurrency() {
		return currency;
	}
    @SuppressWarnings("unused")
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Set<Transaction> getTransactions() {
		return transactions;
	}
    @SuppressWarnings("unused")
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	public void addTransaction(Transaction t) {
		getTransactions().add(t);
		t.setAccount(this);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append("(").append(shortName).append(") ");
		sb.append(accountNum);
		sb.append("/").append(notes);
		sb.append("/").append(openingBalance);
		return sb.toString();
	}
	
	public String getDisplayName() {
		return (shortName == null) ? name : shortName;
	}

}
