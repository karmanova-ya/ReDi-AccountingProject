package services;

import model.BankAccount;
import model.IncomeCategory;
import model.Payment;
import model.PaymentCategory;

import java.util.Scanner;

public class TransactionService {

    public void deposit(BankAccount accTo, double money) { // Unit testing
        accTo.setBalance(money);
        System.out.println(money + "€ has been transferred to your " + accTo.getBankName() + " account");
    }

    public PaymentCategory addPaymentCategory() {
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

    //double amount, Category cat, int month, int year
    public void addPayment() {   // Unit testing for separate parts in separate methods
        Scanner input = new Scanner(System.in);
        Payment payment = new Payment();
        System.out.print("Enter amount -> ");
        double amount = input.nextDouble();
        payment.setPaymentCategory(addPaymentCategory());
        System.out.print("Enter month -> ");
        int month = input.nextInt();
        System.out.print("Enter year -> ");
        int year = input.nextInt();
        payment.setAmount(-amount);
        payment.setMonth(month);
        payment.setYear(year);
        System.out.println("You add a payment: " + payment.getPaymentCategory() + " = " + payment.getAmount() + "€ - " + payment.getMonth() + "." + payment.getYear());
    }


    public void addIncome() {   // testing
    }


}
