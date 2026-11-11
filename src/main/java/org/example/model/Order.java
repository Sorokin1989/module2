package org.example.model;

import org.example.enums.CustomerType;
import org.example.enums.PaymentType;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private final String id;
    private final CustomerType customerType;
    private final PaymentType paymentType;
    private final List<String> items;
    private final BigDecimal amount;

    public Order(String id, CustomerType customerType,
                 PaymentType paymentType, List<String> items,
                 BigDecimal amount) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must not be null and greater than zero");
        }

        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Items must not null and contain at least one item");
        }
        if (paymentType == null) {
            throw new IllegalArgumentException("paymentType must not be null");
        }

        if (customerType == null) {
            throw new IllegalArgumentException("customerType must not be null");
        }
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id must not be null or empty");
        }

        this.id = id;
        this.customerType = customerType;
        this.paymentType = paymentType;
        this.items = List.copyOf(items);
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public List<String> getItems() {
        return items;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
