package org.example.enums;

import org.example.model.Order;
import org.example.strategy.discount.DiscountStrategy;
import org.example.strategy.discount.PremiumDiscount;
import org.example.strategy.discount.RegularDiscount;
import org.example.strategy.discount.VipDiscount;

import java.math.BigDecimal;

public enum CustomerType {
    REGULAR(new RegularDiscount()),
    VIP(new VipDiscount()),
    PREMIUM(new PremiumDiscount());

    private final DiscountStrategy discountStrategy;
    CustomerType(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public BigDecimal calculateDiscount(Order order) {
        return discountStrategy.calculateDiscount(order);
    }
}
