package services;

import enums.TableStatus;
import enums.UserType;
import model.Order;

import java.awt.*;
import java.util.List;

public interface RestrauntAdminService {

    void registerRestraunt(String restrauntName, int numberOfTables , String userType);

    List<TableStatus> displayTableStatus(String restrauntName);

    //bookReservation -> managing tables -> returns 0 for no table OR returns availaible table
    int bookReservation(String restrauntName, int tableNumber);

    void addMenuItems(String restrauntName, String menuItemName, double price, String foodType,
                         String category);

    //all crud operation on menuItems
    boolean updateMenuItems(String restrauntName, String menuItemName, double price);

    boolean removeMenuItem(String restrauntName, String menuItemName);

    List<String> viewMenuItems(String restrauntName);

//    double calculateBill(String restrauntName, Order order);

}
