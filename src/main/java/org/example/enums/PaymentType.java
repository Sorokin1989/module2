package org.example.enums;

import org.example.model.Order;
import org.example.strategy.commission.CardCommission;
import org.example.strategy.commission.CashCommission;
import org.example.strategy.commission.CommissionStrategy;
import org.example.strategy.commission.TransferCommission;

import java.math.BigDecimal;

public enum PaymentType {

    CARD(new CardCommission()),
    CASH(new CashCommission()),
    TRANSFER(new TransferCommission());

    private final CommissionStrategy commissionStrategy;

    PaymentType(CommissionStrategy commissionStrategy) {
        this.commissionStrategy = commissionStrategy;
    }

    public BigDecimal calculate(Order order) {
        return commissionStrategy.calculate(order);
    }
}
