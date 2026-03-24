package org.example.patterns.builder.onlineshop;

public class Order {
    private String item;
    private double price;
    private double discount;
    private String payment;

    private Order(OrderBuilder orderBuilder) {
        this.item = orderBuilder.item;
        this.price = orderBuilder.price;
        this.discount = orderBuilder.discount;
        this.payment = orderBuilder.payment;
    }

    static class OrderBuilder {
        private String item = "fake";
        private double price = 0.0;
        private double discount = 0.0;
        private String payment = "cash";

        public OrderBuilder addItem(String item, double price) {
            this.item = item;
            this.price = price;
            return this;
        }

        public OrderBuilder applyDiscount(double discount) {
            this.price = price - (price * (discount/100));
            return this;
        }

        public OrderBuilder setPayment(String payment) {
            this.payment = payment;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}