package com.aor.refactoring.example3;

public class DiscountNull implements IDiscount {
    public double applyDiscount(double price) {
        return price;
    }
}
