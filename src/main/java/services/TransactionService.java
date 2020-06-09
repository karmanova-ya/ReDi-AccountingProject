package services;

import model.BankAccount;
import model.IncomeCategory;
import model.Payment;
import model.Income;
import model.PaymentCategory;
import utils.DateUtils;

import java.util.Scanner;

public class TransactionService {

    public void deposit(BankAccount accTo, double money) { // Unit testing
        accTo.setBalance(money);
        System.out.println(money + "€ has been transferred to your " + accTo.getBankName() + " account");
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

    public String addPaymentDate(Payment payment) {   // Unit testing for separate parts in separate methods
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month -> ");
        int month = input.nextInt();
        boolean validMonth = false;
        while (!validMonth) {
            if (month > 0 && month <= 12) {
                payment.setMonth(month);
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
                payment.setYear(year);
                validYear = true;
            } else {
                System.out.println("Invalid date. Please check your input\n");
                System.out.print("Enter year -> ");
                year = input.nextInt();
            }
        }
            return DateUtils.month(month) + " " + year;
    }

    //double amount, Category cat, int month, int year
    public void addPayment() {   // Unit testing for separate parts in separate methods
        Scanner input = new Scanner(System.in);
        Payment payment = new Payment();
        System.out.print("Enter amount -> ");
        double amount = input.nextDouble();
        payment.setPaymentCategory(addPayCategory());
        payment.setAmount(-amount);
        String date = addPaymentDate(payment);
        System.out.println("You added a payment: " + payment.getPaymentCategory() + " --> " + payment.getAmount() * (-1) + "€ --> " + date);
    }

//
//    public void addIncome() {   // testing
//        Scanner input = new Scanner(System.in);
//        Income income = new Income();
//        System.out.print("Enter amount -> ");
//        double amount = input.nextDouble();
//        income.setIncomeCategory(addPayCategory());
//        income.setAmount(amount);
//        String date = addPaymentDate(payment);
//        System.out.println("You added a payment: " + payment.getPaymentCategory() + " --> " + payment.getAmount() + "€ --> " + date);
//
//    }


}
