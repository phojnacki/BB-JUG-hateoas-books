package net.hojnacki.bookstore.order;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class OrderRepository {

    private static int currentId = 1;

    private static Map<String, Order> orders = new HashMap<>();

    public Order addOrder(Order order) {
        orders.put(String.valueOf(currentId), order);
        order.setOrderId(String.valueOf(currentId));
        currentId++;
        return order;
    }

    public Order updateOrder(Order order) {
        orders.put(order.getOrderId(), order);
        return order;
    }

    public Order getOrder(String id) {
        return orders.get(id);
    }
}
