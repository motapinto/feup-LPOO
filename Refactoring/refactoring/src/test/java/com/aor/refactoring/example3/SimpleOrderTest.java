package com.aor.refactoring.example3;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleOrderTest {

    @Test
    public void testFixedDiscount() {
        SimpleOrder order = new SimpleOrder(100);
        IDiscount discount = new DiscountFixed(10);
        order.setDiscount(discount);
        assertEquals(90, order.getTotal(), 0.1);
    }

    @Test
    public void testPercentageDiscount() {
        SimpleOrder order = new SimpleOrder(100);
        IDiscount discount = new DiscountPercentage(0.2);
        order.setDiscount(discount);
        assertEquals(80, order.getTotal(), 0.1);
    }

    @Test
    public void testNoDiscount() {
        SimpleOrder order = new SimpleOrder(100);
        IDiscount discount = new DiscountNull();
        order.setDiscount(discount);
        assertEquals(100, order.getTotal(), 0.1);
    }
}