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

    public void addPayment() { // Unit testing for separate parts in separate methods
        //double amount, Category cat, int month, int year
        Scanner input = new Scanner(System.in);

        boolean isContinue = true;
        while (isContinue) {
            System.out.println("Select your spending category: ");
            System.out.println("ENTERTAINMENT (e), CAFE(c), TRANSPORT(t), GROCERY(g)");
            String cat = input.next();
            PaymentCategory payCat = null;
            Payment payment = new Payment();

            switch (cat) {
                case "e":
                    payCat = PaymentCategory.ENTERTAINMENT;
                    payment.setPaymentCategory(payCat);
                    break;
                case "c":
                    payCat = PaymentCategory.CAFE;
                    payment.setPaymentCategory(payCat);
                    break;
                case "t":
                    payCat = PaymentCategory.TRANSPORT;
                    payment.setPaymentCategory(payCat);
                    break;
                case "g":
                    payCat = PaymentCategory.GROCERY;
                    payment.setPaymentCategory(payCat);
                    break;
                default:
                    System.out.println("Please clarify your answer\n");
            }
        }
        double amount = input.nextDouble();
        String cat = input.next();
        PaymentCategory paymentCategory = PaymentCategory.valueOf(cat.toUpperCase());
        if(paymentCategory == null) {
            System.out.println("Invalid category. Please check your input");
        }
        int month = input.nextInt();
        int year = input.nextInt();

    }

    public void addIncome() {   // testing
    }


}
