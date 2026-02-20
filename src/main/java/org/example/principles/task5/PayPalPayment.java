package org.example.principles.task5;

public class PayPalPayment implements IPayment {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата через PayPal на сумму " + amount);
    }
}