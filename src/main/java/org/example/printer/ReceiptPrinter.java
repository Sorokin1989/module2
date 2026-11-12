package org.example.printer;

import org.example.model.Order;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface ReceiptPrinter {
    void printReceipt(Order order, BigDecimal discount, BigDecimal commission, BigDecimal finalAmount);

    default String format(BigDecimal value) {
        return value.setScale(1, RoundingMode.HALF_UP).toPlainString();
    }

}
