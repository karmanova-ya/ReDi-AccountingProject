package model;

import utils.DateUtils;

public class Payment extends Transaction{

    private PaymentCategory paymentCategory;

    @Override
    public String toString() {
        return "Payment{" +
                ", amount=" + getAmount() +
                ", category=" + paymentCategory +
                ", month=" + DateUtils.month(getMonth()) +
                ", year=" + getYear() +
                '}';
    }

    public PaymentCategory getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(PaymentCategory paymentCategory) {
        this.paymentCategory = paymentCategory;
    }
}