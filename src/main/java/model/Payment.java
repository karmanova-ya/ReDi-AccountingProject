package model;

import utils.DateUtils;

public class Payment {
    private double amount;
    private PaymentCategory paymentCategory;
    private Integer month;
    private int year;

    @Override
    public String toString() {
        return "Payment{" +
                ", amount=" + amount +
                ", category=" + paymentCategory +
                ", month=" + DateUtils.month(month) +
                ", year=" + year +
                '}';
    }

//    public Payment(double amount, int month, int year) {
//        this.amount = amount;
//        this.category = category;
//        this.month = month;
//        this.year = year;
//    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentCategory getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(PaymentCategory paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}