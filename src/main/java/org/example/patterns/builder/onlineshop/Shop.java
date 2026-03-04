package org.example.patterns.builder.onlineshop;

public class Shop {
    private String name;
    private Order.OrderBuilder orderBuilder;

    public Shop(String name) {
        this.name = name;
        this.orderBuilder = new Order.OrderBuilder();
    }

    public Order createOrder(String item, double price, double discount, String payment) {
        return orderBuilder.addItem(item, price).applyDiscount(discount).setPayment(payment).build();
    }

    public Order createOrderWithoutDiscount(String item, double price, String payment) {
        return orderBuilder.addItem(item, price).setPayment(payment).build();
    }
}
