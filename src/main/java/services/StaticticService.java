package services;

import model.Income;
import model.Payment;
import model.PaymentCategory;
import repository.IncomeStorage;
import repository.PaymentStorage;
import utils.DateUtils;

import java.util.*;

public class StaticticService {

    private final PaymentStorage paymentStorage;
    private final IncomeStorage incomeStorage;

    public StaticticService(PaymentStorage paymentStorage, IncomeStorage incomeStorage) {
        this.paymentStorage = paymentStorage;
        this.incomeStorage = incomeStorage;
    }

    //Give the user opportunity to choose what statistics they want to see:
    public void selectStatistics() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter what statistics you want to see:");
        System.out.println(
                "1 - My biggest payment\n" +
                        "2 - My total income\n" +
                        "3 - How do I spend my money\n" +
                        "4 - Statistics for 1 year\n" +
                        "0 - exit\n");
        boolean isContinue = true;
        while (isContinue) {

            System.out.print("User's input> ");
            int cat = input.nextInt();

            switch (cat) {
                case 1:
                    biggestPayment();
                    break;
                case 2:
                    totalIncome();
                    break;
                case 3:
                    paymentAlphGrouping();
                    break;
                case 4:
                    System.out.println("Enter a year:");
                    cat = input.nextInt();
                    totalSpendingByYear(cat);
                    break;
                case 0:
                    System.out.println("See you next time :)\n");
                    isContinue = false;
                    break;
                default:
                    System.out.println("Please clarify your answer\n");
            }
        }
    }

    //Show the user their the most expensive payment
    public Payment biggestPayment() {
        Payment big = null;
        for (Payment payment : paymentStorage.getPayments()) {
            if (big == null) {
                big = payment;
            } else if (payment.getAmount() < 0 && big.getAmount() > payment.getAmount()) {
                big = payment;
            }
        }
        System.out.println("The biggest payment is: " + big);
        return big;
    }

    //Show the user their total income
    public double totalIncome() {
        double sum = 0;
        for (Income income : incomeStorage.getIncomes()) {
            if (income.getAmount() > 0) {
                sum += income.getAmount();
            }
        }
        System.out.println("The total income is: " + sum);
        return sum;
    }

    //Show the user their spending grouped by type, alphabetically ordered by the type name
    public void paymentAlphGrouping() {
        TreeMap<PaymentCategory, Double> alphabetSort = new TreeMap();
        for (Payment payment : paymentStorage.getPayments()) {
            PaymentCategory paymentCategory = payment.getPaymentCategory();
            if (alphabetSort.containsKey(paymentCategory)) {
                double sum = alphabetSort.get(paymentCategory) + payment.getAmount();
                alphabetSort.put(paymentCategory, sum);
            } else {
                alphabetSort.put(paymentCategory, payment.getAmount());
            }
        }
        System.out.println("How do you spend your money: ");
        for (Map.Entry<PaymentCategory, Double> entry : alphabetSort.entrySet()) {
            System.out.println(entry);
        }
    }


    //Show the user their biggest income
    public Income biggestIncome() {
        Income big = null;
        for (Income income : incomeStorage.getIncomes()) {
            if (income.getAmount() > 0) {
                if (big == null) {
                    big = income;
                } else if (big.getAmount() < income.getAmount()) {
                    big = income;
                }
            }
        }
        System.out.println("The biggest income is: " + big);
        return big;
    }

    //Show the user their total spending
    public double totalSpending() {
        double sum = 0;
        for (Payment payment : paymentStorage.getPayments()) {
            sum += payment.getAmount();
        }
        System.out.println("You spent in total: " + sum);
        return sum;
    }

    //Show spendings & earnings grouped by month during this year, chronologically ordered.
    public void totalSpendingByMonth() {
        HashMap<Integer, Double> spendings = new HashMap();
        HashMap<Integer, Double> earnings = new HashMap();

        for (Payment payment : paymentStorage.getPayments()) {
            Integer month = payment.getMonth();
            Date key = new GregorianCalendar(payment.getYear(), payment.getMonth() - 1, 0).getTime();
            if (spendings.containsKey(month)) {
                Double currentSum = spendings.get(month);
                currentSum += payment.getAmount();
                spendings.put(month, currentSum);
            } else {
                spendings.put(month, payment.getAmount());
            }
        }

        for (Income income : incomeStorage.getIncomes()) {
            Integer month = income.getMonth();
            Date key = new GregorianCalendar(income.getYear(), income.getMonth() - 1, 0).getTime();
            if (earnings.containsKey(month)) {
                Double currentSum = earnings.get(month) + income.getAmount();
                earnings.put(month, currentSum);
            } else {
                earnings.put(month, income.getAmount());
            }
        }
        for (int i = 1; i <= 12; i++) {
            System.out.println("In " + DateUtils.month(i) + " you spent: " + spendings.getOrDefault(i, 0d) + "€" + " and earned: " + earnings.getOrDefault(i, 0d) + "€");
        }
    }

    //Show spendings & earnings grouped by month during chosen year, chronologically ordered.
    public void totalSpendingByYear(int year) {
        HashMap<Integer, Double> spendings = new HashMap<>();
        HashMap<Integer, Double> earnings = new HashMap<>();
        for (Payment payment : paymentStorage.getPayments()) {
            Integer month = payment.getMonth();
            Date key = new GregorianCalendar(year, payment.getMonth() - 1, 0).getTime();
            if (payment.getYear() == year) {
                if (spendings.containsKey(month)) {
                    Double currentSum = spendings.get(month);
                    currentSum += payment.getAmount();
                    spendings.put(month, currentSum);
                } else {
                    spendings.put(month, payment.getAmount());
                }
            }
        }

        for (Income income : incomeStorage.getIncomes()) {
            Integer month = income.getMonth();
            Date key = new GregorianCalendar(year, income.getMonth() - 1, 0).getTime();
            if (income.getYear() == year) {
                if (earnings.containsKey(month)) {
                    Double currentSum = earnings.get(month) + income.getAmount();
                    earnings.put(month, currentSum);
                } else {
                    earnings.put(month, income.getAmount());
                }
            }
        }
        for (int i = 1; i <= 12; i++) {
            Double spent = spendings.get(i);
            Double earned = earnings.get(i);
            if (spent != null || earned != null) {
                System.out.println("In " + DateUtils.month(i) + " " + year + " you spent: " + spendings.getOrDefault(i, 0d) + "€" + " and earned: " + earnings.getOrDefault(i, 0d) + "€");
            }
        }
    }
}
