package org.example.strategy.discount;

import org.example.model.Order;

import java.math.BigDecimal;

public class RegularDiscount implements DiscountStrategy {

    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.00");

    @Override
    public BigDecimal calculateDiscount(Order order) {
        return order.getAmount().multiply(DISCOUNT_RATE);
    }
}
