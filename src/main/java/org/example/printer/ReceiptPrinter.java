package org.example.printer;

import org.example.model.Order;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReceiptPrinter {


    public  void printReceipt(Order order, BigDecimal discount,
                              BigDecimal commission, BigDecimal finalAmount) {
        System.out.println("=== RECEIPT ===");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Items: " + order.getItems());
        System.out.println("Base amount: " + format(order.getAmount()));
        System.out.println("Discount: -" + format(discount));
        System.out.println("Commission: +" + format(commission));
        System.out.println("Final amount: " + format(finalAmount));
        System.out.println("================");
    }

    private String format(BigDecimal value) {
        return value.setScale(1, RoundingMode.HALF_UP).toPlainString();
    }
}
