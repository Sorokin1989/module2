package org.example;

import org.example.enums.CustomerType;
import org.example.enums.PaymentType;
import org.example.model.Order;
import org.example.printer.ReceiptPrinter;
import org.example.service.OrderService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        OrderService service = new OrderService(new ArrayList<>(),new ReceiptPrinter());

        Order order1 = new Order("1", CustomerType.VIP,
                PaymentType.CARD,
                List.of("Laptop", "Mouse"),
                new BigDecimal("1000"));
        Order order2 = new Order("2", CustomerType.REGULAR,
                PaymentType.CASH,
                List.of("Book"),
                new BigDecimal("20"));

        System.out.println("Final amount 1: " + service.processOrder(order1));
        System.out.println("Final amount 2: " + service.processOrder(order2));
    }
}