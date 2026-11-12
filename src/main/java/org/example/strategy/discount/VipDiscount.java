package org.example.strategy.discount;

import org.example.model.Order;

import java.math.BigDecimal;

public class VipDiscount implements DiscountStrategy {

    private static final BigDecimal VIP_RATE = new BigDecimal("0.05");

    @Override
    public BigDecimal calculateDiscount(Order order) {
        return order.getAmount().multiply(VIP_RATE);
    }
}
