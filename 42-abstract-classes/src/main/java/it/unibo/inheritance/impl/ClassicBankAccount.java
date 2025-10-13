package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;

public class ClassicBankAccount extends AbstractBankAccount {
    public ClassicBankAccount(final AccountHolder holder, final double balance){
        super(holder, balance);
    }

    protected boolean isWithDrawAllowed(double amount){
        return true;
    }

    protected  double computeFee(){
        return 0;
    }
}
