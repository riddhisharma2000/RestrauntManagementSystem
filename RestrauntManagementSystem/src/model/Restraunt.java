package model;

import enums.OrderStatus;
import enums.TableStatus;
import enums.UserType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Restraunt {
  //  private static Restraunt instance;
    private String restrauntName;
    private UserType userType;
    private List<Table> tablesList;
    private List<MenuItem> menu;
    private Order order;
//    private Map<Integer, String> orders;
    // map<tableNumber,


    public Restraunt(String restrauntName, UserType userType,  int numberOfTables){
        this.restrauntName = restrauntName;
        this.userType = userType;
        menu = new ArrayList<>();
        this.tablesList = new ArrayList<Table>(numberOfTables);

        for(int i=0; i<numberOfTables; i++) {
            this.tablesList.add(new Table(i+1, TableStatus.VACANT));
        }
    }

//    public static synchronized Restraunt getInstance() {
//        if (instance == null)
//        {
//            instance = new Restraunt();
//        }
//        return instance;
//    }

    public void addTables(Table table){
        this.tablesList.add(table);
    }

    public void addMenuItem(MenuItem item)
    {
        menu.add(item);
    }

    public void removeMenuItem(MenuItem item)
    {
        menu.remove(item);
    }

    public void updateMenuItemPrice(MenuItem item, double price)
    {
        if(!menu.contains(item)){
            // throw exception
        }
       item.setPrice(price);

    }


    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(MenuItem menuItem) {
        this.menu.add(menuItem);
    }


    public synchronized int bookTable(int tableNumber){
        if(tablesList.isEmpty())
        {
           // throw exception - TableListisEmpty
        }

        for(Table table : tablesList) {

            // happyCase - when desiredTableNumber is available
            if(table.getTableNumber() == tableNumber && table.getTableStatus().equals(TableStatus.VACANT)) {
                table.setTableStatus(TableStatus.OCCUPIED);
                return tableNumber;
            }

            // if desiredTableNumber is available, get the first one which is vacant
            if(table.getTableStatus().equals(TableStatus.VACANT)) {
                return tableNumber;
            }

        }
        return -1;
    }

//    public void updateMenuItems(MenuItem menuItem) {
//
//    }

//    public void updateOrderStatus(int orderID, OrderStatus orderStatus)
//    {
//        Order order = orders.get(orderID);
//        if(order != null)
//        {
//            order.setOrderStatus(orderStatus);
//            notifyStaff(order);
//        }
//    }

    public Order getOrder() {
        //return new ArrayList<Order>(orders.values());
        return this.order;
    }

    public String getRestrauntName() {
        return restrauntName;
    }

    public List<Table> getTablesList() {
        return this.tablesList;
    }

    public void setOrder(Order order) {
        this.order = order;

        // orders.put(order.getOrderId(), order);
    }



    public void notifyStaff(Order order)
    {
        //notify staff
    }
}
