package model;

import enums.OrderStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Order {
    private final String orderId;
    private Map<String, Integer> menuItems_Quantity;
    private double totalAmount;
    private OrderStatus orderStatus;

    public Order() {
        this.orderId = UUID.randomUUID().toString();
        this.menuItems_Quantity = new HashMap<>();

    }

    public void updateOrder(Map<String, Integer> menuItems_Quantity, double totalAmount, OrderStatus orderStatus)
    {
        this.menuItems_Quantity = menuItems_Quantity;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double amount) {
        this.totalAmount = amount;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Map<String , Integer> getMenuItems() {
        return this.menuItems_Quantity;
    }

    public void setMenuItems(int quantity, String menuItemName) {
        this.menuItems_Quantity.put(menuItemName, menuItems_Quantity.getOrDefault(menuItemName, 0)+quantity);
    }

    public void removeMenuItems(int quantity, String menuItemName) {
        this.menuItems_Quantity.remove(menuItemName, menuItems_Quantity.getOrDefault(menuItemName, 0) - quantity);
    }

}


