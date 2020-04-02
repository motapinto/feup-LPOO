package com.aor.refactoring.example3;

public class DiscountPercentage implements IDiscount {
    private double percentage;

    public DiscountPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double applyDiscount(double price) {
        double discountedPrice = price;

        if (percentage > 0)
            discountedPrice = price - price * percentage;

        return discountedPrice;
    }
}