package org.example.strategy.commission;

import org.example.model.Order;

import java.math.BigDecimal;

public class TransferCommission implements CommissionStrategy {

    private static final BigDecimal COMMISSION_RATE = new BigDecimal("0.01");

    @Override
    public BigDecimal calculate(Order order) {
        return order.getAmount().multiply(COMMISSION_RATE);
    }
}
