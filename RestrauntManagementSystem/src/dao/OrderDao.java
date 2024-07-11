package dao;

import model.Order;
import model.Restraunt;

import java.util.Date;
import java.util.Map;

public class OrderDao {
    private static OrderDao orderDaoInstance;
    private Order order;

    private OrderDao() {
        this.order = new Order();
    }

    public static OrderDao getInstance() {
        if(orderDaoInstance == null)
        {
            orderDaoInstance = new OrderDao();
        }
        return orderDaoInstance;
    }

    public Order getOrder() {
        return order;
    }

    public void updateOrder(int quantity, String menuItemName) {
        this.order.setMenuItems(quantity, menuItemName);
    }

    public void removeItemsFromOrder(int quantity, String menuItemName) {
        this.order.removeMenuItems(quantity, menuItemName);
    }

}
