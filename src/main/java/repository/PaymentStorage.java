package repository;

import model.Income;
import model.Payment;

import java.util.HashSet;

public class PaymentStorage {
    HashSet<Payment> payments = new HashSet();

    public void addPayment(Payment payment){
        payments.add(payment);
    }

    public HashSet<Payment> getPayments() {
        return this.payments;
    }

}
