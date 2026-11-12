package org.example.strategy.discount;

import org.example.model.Order;

import java.math.BigDecimal;

public interface DiscountStrategy {
     BigDecimal calculateDiscount(Order order);
}
