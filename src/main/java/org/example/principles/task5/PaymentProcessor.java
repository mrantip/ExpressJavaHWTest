package org.example.principles.task5;

public class PaymentProcessor {
    public void processPayment(IPayment payment, double amount) {
        payment.pay(amount);
    }
}