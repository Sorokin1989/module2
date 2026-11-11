package org.example.printer;

import org.example.model.Order;

import java.math.BigDecimal;

public class ReceiptPrinter {


    public  void printReceipt(Order order, BigDecimal discount,
                              BigDecimal commission, BigDecimal finalAmount) {
        System.out.println("=== RECEIPT ===");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Items: " + order.getItems());
        System.out.println("Base amount: " + order.getAmount());
        System.out.println("Discount: -" + discount);
        System.out.println("Commission: +" + commission);
        System.out.println("Final amount: " + finalAmount);
        System.out.println("================");
    }
}
