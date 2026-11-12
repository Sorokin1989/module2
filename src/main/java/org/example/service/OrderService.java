package org.example.service;
import org.example.model.Order;
import org.example.printer.ReceiptPrinter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Контекст: Тебе достался в наследство код от предыдущего разработчика — сервис обработки заказов интернет-магазина OrderService.
 * Он работает, тесты (если бы они были) прошли бы, заказчик доволен... пока не попросил добавить новый тип клиента или способ оплаты.
 * Тут выясняется, что каждое такое "простое" изменение требует лезть в один и тот же метод на 80 строк, где всё завязано друг на друга,
 * и есть риск что-то сломать в соседней логике.
 * Твоя задача: не переписать сервис с нуля, а отрефакторить — сохранив то же поведение (те же скидки, та же комиссия, тот же чек)
 * Опирайся на SOLID и паттерны проектирования
 * Lombok использовать нельзя, все писать руками.
 */
public class OrderService {

    private final List<Order> orders;

    private final ReceiptPrinter receiptPrinter;

    public OrderService(List<Order> orders, ReceiptPrinter receiptPrinter) {
        this.orders = orders;
        this.receiptPrinter = receiptPrinter;

    }

    public BigDecimal processOrder(Order order) {

        validate(order);

        // --- расчёт скидки по типу клиента ---
        BigDecimal discount = order.getCustomerType().calculateDiscount(order);
        // --- расчёт комиссии по способу оплаты ---
        BigDecimal commission = order.getPaymentType().calculate(order);
        // --- итоговая сумма ---
        BigDecimal finalAmount = calculateFinalAmount(order, discount, commission);
        // --- формирование чека прямо тут ---
        receiptPrinter.printReceipt(order, discount, commission, finalAmount);
        // --- "сохранение" заказа  ---
        orders.add(order);
        return finalAmount;
    }

    private void validate(Order order) {

        if (order.getAmount() == null || order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must not be null and greater than zero");
        }

        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Items must not null and contain at least one item");
        }
        if (order.getPaymentType() == null) {
            throw new IllegalArgumentException("paymentType must not be null");
        }

        if (order.getCustomerType() == null) {
            throw new IllegalArgumentException("customerType must not be null");
        }
        if (order.getId() == null || order.getId().isEmpty()) {
            throw new IllegalArgumentException("id must not be null or empty");
        }
    }

    private BigDecimal calculateFinalAmount
            (Order order, BigDecimal discount, BigDecimal commission) {
        return order.getAmount()
                .subtract(discount)
                .add(commission)
                .setScale(1, RoundingMode.HALF_UP);

    }


}

