package com.aor.refactoring.example3;

public class DiscountFixed implements IDiscount {
    private int fixed;

    public DiscountFixed(int fixed) {
        this.fixed = fixed;
    }

    public double applyDiscount(double price) {
        double discountedPrice = price;

        if (fixed > 0)
            discountedPrice = fixed > price ? 0 : price - fixed;

        return discountedPrice;
    }
}