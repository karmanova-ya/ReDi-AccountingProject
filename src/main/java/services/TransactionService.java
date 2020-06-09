package services;

import model.*;
import repository.IncomeStorage;
import repository.PaymentStorage;
import utils.DateUtils;

import java.util.Scanner;

public class TransactionService {
    private final PaymentStorage paymentStorage;
    private final IncomeStorage incomeStorage;

    public TransactionService(PaymentStorage paymentStorage, IncomeStorage incomeStorage) {
        this.paymentStorage = paymentStorage;
        this.incomeStorage = incomeStorage;
    }

    //deposit of money in a bank account
    public void deposit(BankAccount accTo, double money) { // Unit testing
        accTo.setBalance(money);
        System.out.println(money + "€ has been transferred to your " + accTo.getBankName() + " account");
    }

    //account withdraw
    void withdraw(BankAccount bAcc, double money) {
        System.out.print(" -" + money);
        if (money <= bAcc.getBalance()) {
            bAcc.setBalance(-money);
            System.out.println(" = " + bAcc.getBalance());
        } else {
            System.out.print(" You don't have enough money on your balance :(");
            System.out.println(" = " + bAcc.getBalance());
        }
    }

    public PaymentCategory addPayCategory() {
        Scanner input = new Scanner(System.in);
        System.out.println("Select your spending category: ");
        System.out.println("ENTERTAINMENT (e), CAFE(c), TRANSPORT(t), GROCERY(g)");
        String cat = input.next();
        PaymentCategory payCat = null;

        boolean isContinue = true;
        while (isContinue) {
            switch (cat) {
                case "e":
                    payCat = PaymentCategory.ENTERTAINMENT;
                    isContinue = false;
                    break;
                case "c":
                    payCat = PaymentCategory.CAFE;
                    isContinue = false;
                    break;
                case "t":
                    payCat = PaymentCategory.TRANSPORT;
                    isContinue = false;
                    break;
                case "g":
                    payCat = PaymentCategory.GROCERY;
                    isContinue = false;
                    break;
                default:
                    System.out.println("Invalid category. Please check your input\n");
                    System.out.println("Select your spending category: ");
                    System.out.println("ENTERTAINMENT (e), CAFE(c), TRANSPORT(t), GROCERY(g)");
                    cat = input.next();
            }
        }
        return payCat;
    }

    public IncomeCategory addInCategory() {
        Scanner input = new Scanner(System.in);
        System.out.println("Select your income category: ");
        System.out.println("SALARY(s), DIVIDEND(d), KINDERGELD(k)");
        String cat = input.next();
        IncomeCategory inCat = null;

        boolean isContinue = true;
        while (isContinue) {
            switch (cat) {
                case "s":
                    inCat = IncomeCategory.SALARY;
                    isContinue = false;
                    break;
                case "d":
                    inCat = IncomeCategory.DIVIDEND;
                    isContinue = false;
                    break;
                case "k":
                    inCat = IncomeCategory.KINDERGELD;
                    isContinue = false;
                    break;
                default:
                    System.out.println("Invalid category. Please check your input\n");
                    System.out.println("Select your income category: ");
                    System.out.println("SALARY(s), DIVIDEND(d), KINDERGELD(k)");
                    cat = input.next();
            }
        }
        return inCat;
    }

    public String addPaymentDate(Transaction transaction) {   // Unit testing
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month -> ");
        int month = input.nextInt();
        boolean validMonth = false;
        while (!validMonth) {
            if (month > 0 && month <= 12) {
                transaction.setMonth(month);
                validMonth = true;
            } else {
                System.out.println("Invalid date. Please check your input\n");
                System.out.print("Enter month -> ");
                month = input.nextInt();
            }
        }
        System.out.print("Enter year -> ");
        int year = input.nextInt();
        boolean validYear = false;
        while (!validYear) {
            if (year == 2019 || year == 2020) {
                transaction.setYear(year);
                validYear = true;
            } else {
                System.out.println("Invalid date. Please check your input\n");
                System.out.print("Enter year -> ");
                year = input.nextInt();
            }
        }
        return DateUtils.month(month) + " " + year;
    }

    //add some payments in our bank
    public void addPayment() {   // Unit testing
        Scanner input = new Scanner(System.in);
        Payment payment = new Payment();
        System.out.print("Enter amount -> ");
        double amount = input.nextDouble();
        payment.setPaymentCategory(addPayCategory());
        payment.setAmount(-amount);
        String date = addPaymentDate(payment);
        System.out.println("You added a transaction: " + payment.getPaymentCategory() + " --> " + payment.getAmount() * (-1) + "€ --> " + date);
    }

    //add income transactions in our bank
    public void addIncome() {              //  Unit testing
        Scanner input = new Scanner(System.in);
        Income income = new Income();
        System.out.print("Enter amount -> ");
        double amount = input.nextDouble();
        income.setInCategory(addInCategory());
        income.setAmount(amount);
        String date = addPaymentDate(income);
        System.out.println("You added a transaction: " + income.getInCategory() + " --> " + income.getAmount() + "€ --> " + date);
    }

//    void transfer(BankAccount accTo, double tranTo) {
//        withdraw(BankAccount bAcc, tranTo);
//
////        accTo.deposit(tranTo);
//        System.out.println("Transfer complete!");
//        System.out.println(this.bankName + " - " + this.getBalance());
//        System.out.println(accTo.bankName + " - " + accTo.getBalance());
//    }
}
