package model;

import java.io.Serializable;

public class BankAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    private String bankName;
    private double balance = 0;

    public BankAccount(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
