package org.example.strategy.commission;

import org.example.model.Order;

import java.math.BigDecimal;

public interface CommissionStrategy {
    BigDecimal calculate(Order order);
}
