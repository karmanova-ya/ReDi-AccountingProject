package model;
// its for Yana
public class BankAccount {
    private String bankName;
    private double balance = 0;

    public BankAccount(String bankName) {
        this.bankName = bankName;
    }

    void withdraw(double money) {
        System.out.print(" -" + money);
        if (money <= balance) {
            balance -= money;
            System.out.println(" = " + balance);
        } else {
            System.out.print(" You don't have enough money on your balance :(");
            System.out.println(" = " + balance);
        }
    }

    void transfer(BankAccount accTo, double tranTo) {
        withdraw(tranTo);

//        accTo.deposit(tranTo);
        System.out.println("Transfer complete!");
        System.out.println(this.bankName + " - " + this.getBalance());
        System.out.println(accTo.bankName + " - " + accTo.getBalance());
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
