package org.example.strategy.commission;

import org.example.model.Order;

import java.math.BigDecimal;

public class CashCommission implements CommissionStrategy {

    @Override
    public BigDecimal calculate(Order order) {
        return BigDecimal.ZERO;
    }
}
