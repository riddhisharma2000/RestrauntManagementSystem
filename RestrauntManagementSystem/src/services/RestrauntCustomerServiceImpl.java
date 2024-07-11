package services;

import Strategy.CategoryBasedStrategy;
import Strategy.FoodTypeBasedStrategy;
import Strategy.RestrauntMenuDisplayStrategy;
import dao.OrderDao;
import dao.RestrauntDao;
import dao.UserDao;
import enums.*;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestrauntCustomerServiceImpl implements RestrauntCustomerService{

    // declare a restrautDao
    RestrauntDao restrauntDao;
    UserDao userDao;
    OrderDao orderDao;

    public RestrauntCustomerServiceImpl(){
        this.restrauntDao = RestrauntDao.getInstance();
        this.userDao = UserDao.getInstance();
        this.orderDao = OrderDao.getInstance();
    }

    @Override
    public List<MenuItem> viewRestrauntMenu(String restrauntName, String sortBy, String userType) {

        if (!userType.toLowerCase().equals("customer")) {
            // throw exception
        }

        RestrauntMenuDisplayStrategy strategy = null;

      //  String check = sortBy.equals(FoodType.valueOf("VEG")) ? "VEG" : "NON_VEG";
        // VEG- vegList -> foodtype
        // NOn-veg - nonVegList

        if(sortBy.equals("foodtype")) {
            strategy = new FoodTypeBasedStrategy();
        }
        if(sortBy.equals("category")) {
            strategy = new CategoryBasedStrategy();
        }
        if(strategy != null)
        {
            //return restrauntMenu on the basis
            return strategy.findRestrauntMenu(restrauntDao.getRestaurant(restrauntName));
        }

        return new ArrayList<>();
    }



    @Override
    public void addItemsToOrder(int quantity, String menuItemName, String userType) {

        // List<Integer, String>

        if (!userType.toLowerCase().equals("customer")) {
            // throw exception
        }

        orderDao.updateOrder(quantity, menuItemName);

       // List<MenuItem> menuItemList_Restraunt = restraunt.getMenu();

//        List<MenuItem> menuItemList_Customers = new ArrayList<>();
//        double totalAmount = 0.0;
//
//        for(MenuItem menuItem : menuItemList_Restraunt) {
//            if(menuItem.getMenuName().equals(menuItemName)) {
//                //update inventory
//                menuItem.updateInventory(quantity);
//               menuItemList_Customers.add(menuItem);
//               totalAmount += menuItem.getPrice();
//            }
//        }
//
//        // place order
//        restraunt.placeOrder(new Order(menuItemList_Customers, totalAmount, OrderStatus.PREPARING));
//
//        //mark the
//        return true;
    }

    @Override
    public void deleteItemsFromOrder(int quantity, String menuItemName, String userType) {
        if (!userType.toLowerCase().equals("customer")) {
            // throw exception
        }

        orderDao.removeItemsFromOrder(quantity, menuItemName);
    }

//    public double getOrderPrice() {
//        Map<String, Double> menuItems_Quantity = order.getMenuItems();
//        for(Map.Entry<String, Double> mp : menuItems_Quantity.entrySet()) {
//            String menuItem = mp.getKey();
//
//        }
//
//    }

    @Override
    public void placeOrder(String restrauntName, String userType) {
        Restraunt restraunt = restrauntDao.getRestaurant(restrauntName);

        double totalAmount = 0.0;
        Order currentOrder = orderDao.getOrder();
        Map<String, Integer> menuItems_Quantity = currentOrder.getMenuItems();
        // marghrita - 2


        for(Map.Entry<String, Integer> mp : menuItems_Quantity.entrySet()) {
            String menuItemName = mp.getKey();
            Integer numberOfItems = mp.getValue();

            List<MenuItem> menuItemList_Restraunt = restraunt.getMenu();
            for(MenuItem menuItem : menuItemList_Restraunt) {
            if(menuItem.getMenuName().equals(menuItemName)) {

                      totalAmount +=  menuItem.getPrice() * numberOfItems;
            }
        }
        }
        currentOrder.setTotalAmount(totalAmount);

    }



    @Override
    public boolean payBill(String restrauntName, String paymentMethod, String userType) {

        if (!userType.toLowerCase().equals("customer")) {
            // throw exception
            return false;
        }

        Restraunt restraunt = restrauntDao.getRestaurant(restrauntName);
        Order currentOrder = orderDao.getOrder();

        // payment processing
        Payment userPayment = new Payment(currentOrder.getTotalAmount(),
                PaymentMethod.valueOf(paymentMethod.toUpperCase()));

        Double userBill = userPayment.getPayment();

        System.out.println("Amount to be paid " + userBill + "in chosen payment method" + paymentMethod);

        int tableNumberOccupied = userDao.getCurrentLoginUser().getTable().getTableNumber();
        // update table status:
        restraunt.getTablesList().get(tableNumberOccupied).setTableStatus(TableStatus.VACANT);

        return true;
    }


}
