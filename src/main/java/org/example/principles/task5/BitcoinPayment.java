package org.example.principles.task5;

public class BitcoinPayment implements IPayment {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата Bitcoin на сумму " + amount);
    }
}