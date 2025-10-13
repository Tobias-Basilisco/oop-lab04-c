package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;

public class RestrictedBankAccount extends AbstractBankAccount {
    protected static final double TRANSACTION_FEE = 0.1;


    public RestrictedBankAccount(final AccountHolder holder, final double balance){
        super(holder, balance);
    }

    protected boolean isWithDrawAllowed(double amount){
        return super.getBalance() >= amount;
    }

    protected  double computeFee(){
        return MANAGEMENT_FEE + getTransactionsCount() * TRANSACTION_FEE;
    }
}
