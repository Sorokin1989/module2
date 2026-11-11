package org.example.strategy.discount;

import org.example.model.Order;

import java.math.BigDecimal;

public class PremiumDiscount implements DiscountStrategy {

    private static final BigDecimal PREMIUM_RATE = new BigDecimal("0.10");
    @Override
    public BigDecimal calculateDiscount(Order order) {
        return order.getAmount().multiply(PREMIUM_RATE);
    }
}
