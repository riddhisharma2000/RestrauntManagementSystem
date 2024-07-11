package services;

import enums.UserType;
import model.MenuItem;
import model.Restraunt;

import java.util.List;

public interface RestrauntCustomerService {

    List<MenuItem> viewRestrauntMenu(String restrauntName, String sortBy, String userType);
    void addItemsToOrder(int quantity, String menuItemName, String userType);
    void deleteItemsFromOrder(int quantity, String menuItemName, String userType);
    void placeOrder(String restrauntName, String userType);
    boolean payBill(String restrauntName, String paymentMethod, String userType);
}

// todo
// paybill
// calculateBill