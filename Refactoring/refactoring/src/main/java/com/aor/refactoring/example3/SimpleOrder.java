package com.aor.refactoring.example3;

public class SimpleOrder {
    private IDiscount discount = new DiscountNull();
    private double price;

    public SimpleOrder(double price) {
        this.price = price;
    }

    public void setDiscount(IDiscount discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return discount.applyDiscount(price);
    }
}
