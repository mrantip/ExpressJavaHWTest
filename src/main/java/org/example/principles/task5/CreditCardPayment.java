package org.example.principles.task5;

public class CreditCardPayment implements IPayment {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата кредитной картой на сумму " + amount);
    }
}