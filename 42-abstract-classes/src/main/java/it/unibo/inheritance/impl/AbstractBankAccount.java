package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;
import it.unibo.inheritance.api.BankAccount;

abstract class AbstractBankAccount implements BankAccount{
    protected static final double ATM_TRANSACTION_FEE = 1;
    protected static final double MANAGEMENT_FEE = 5;


    private final AccountHolder holder;
    private double balance;
    private int transactions;

    public AbstractBankAccount(final AccountHolder holder, final double balance){
        this.holder = holder;
        setBalance(balance);
    } 

    public AccountHolder getAccountHolder(){
        return this.holder;
    }

    public double getBalance(){
        return this.balance;
    }

    public int getTransactionsCount(){
        return this.transactions;
    }

    public void setBalance(final double balance){
        this.balance = balance;
    }

    public void chargeManagementFees(int id){
        setBalance(getBalance() - computeFee());
        resetTransactions();
    }

    public void deposit(int id, double amount){
        transactionOp(id, amount);
    }
    
    public void depositFromATM(int id, double amount){
        transactionOp(id, amount - ATM_TRANSACTION_FEE);
    }

    public void withdraw(int id, double amount){
        if(isWithDrawAllowed(amount)){
            transactionOp(id, -amount);
        }
    }

    public void withdrawFromATM(int id, double amount){
        withdraw(id, amount + ATM_TRANSACTION_FEE);
    }

    protected abstract boolean isWithDrawAllowed(double amount);

    protected abstract double computeFee();

    protected boolean checkUser(final int id) {
        return this.getAccountHolder().getUserID() == id;
    }

    protected void incrementTransactions() {
        this.transactions++;
    }

    protected void resetTransactions() {
        this.transactions = 0;
    }

    private void transactionOp(final int id, final double amount) {
        if (checkUser(id)) {
            setBalance(getBalance() + amount);
            this.incrementTransactions();
        }
    }
}