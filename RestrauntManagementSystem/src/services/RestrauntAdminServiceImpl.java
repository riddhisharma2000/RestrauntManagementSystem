package services;

import dao.RestrauntDao;
import dao.UserDao;
import enums.Category;
import enums.FoodType;
import enums.TableStatus;
import enums.UserType;
import model.MenuItem;
import model.Restraunt;
import model.Table;

import java.util.ArrayList;
import java.util.List;

public class RestrauntAdminServiceImpl implements RestrauntAdminService{

    RestrauntDao restrauntDao;
    UserDao userDao;


    public RestrauntAdminServiceImpl(){
        this.restrauntDao = RestrauntDao.getInstance();
        this.userDao = UserDao.getInstance();

    }

    @Override
    public void registerRestraunt(String restrauntName, int numberOfTables , String userType) {
//
        if (!userType.toLowerCase().equals("admin")) {
            // throw exception
        }


        Restraunt restraunt = new Restraunt(restrauntName, UserType.ADMIN, numberOfTables);
        this.restrauntDao.addRestaurant(restraunt);

//        this.restrauntDao.addRestaurant(restrauntName, UserType.ADMIN
//                , numberOfTables);
        // numberOfTables - 0,1,2,3...

    }

    @Override
    public List<TableStatus> displayTableStatus(String restrauntName) {
        Restraunt restraunt = this.restrauntDao.getRestaurant(restrauntName);

        List<Table> tablesList =  restraunt.getTablesList();
        List<TableStatus> tableStatuses = new ArrayList<>();

        for(Table table : tablesList)
        {
            System.out.println("Table " + table.getTableNumber() + " Status: " + table.getTableStatus());
        }

        return tableStatuses;

        //        for(Table table : tablesList)
//        {
//            tableStatuses.add(table.getTableStatus());
//        }

    }

    @Override
    public void addMenuItems(String restrauntName, String menuItemName, double price, String foodType,
                                String category) {
        Restraunt restraunt = this.restrauntDao.getRestaurant(restrauntName);

      //  Category category_given = Category.valueOf();

//        if(category.toLowerCase().equals("starter")) {
//            category_given = Category.STARTER;
//        }
//        else if(category.toLowerCase().equals("dessert")) {
//            category_given = Category.DESSERT;
//        }
//        else if(category.toLowerCase().equals("maincourse")) {
//            category_given = Category.MAIN_COURSE;
//        }

        if (restraunt != null) {
            restraunt.setMenu(new MenuItem(menuItemName, price,
                    foodType.toLowerCase().equals("veg") ? FoodType.VEG : FoodType.NON_VEG ,
                    Category.valueOf(category.toUpperCase())));
        }


    }

    @Override
    public boolean updateMenuItems(String restrauntName, String menuItemName, double price){
        Restraunt restraunt = restrauntDao.getRestaurant(restrauntName);

        if(restraunt != null) {
            List<MenuItem> menuItemList = restraunt.getMenu();

            for(MenuItem menuItem : menuItemList) {
                if (menuItem.getMenuName().equals(menuItemName)) {
                    menuItem.setPrice(price);
                    return true;
                }
            }

        }

        return false;

    }


    @Override
    public boolean removeMenuItem(String restrauntName, String menuItemName) {
        Restraunt restraunt = restrauntDao.getRestaurant(restrauntName);

        if (restraunt != null) {
            List<MenuItem> menuItemList = restraunt.getMenu();

            for(MenuItem menuItem : menuItemList) {
                if (menuItem.getMenuName().equals(menuItemName)) {
                    restraunt.removeMenuItem(menuItem);
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public List<String> viewMenuItems(String restrauntName) {
        Restraunt restraunt = restrauntDao.getRestaurant(restrauntName);
        List<MenuItem> menuItemList = restraunt.getMenu();
        List<String> menuItems = new ArrayList<>();

        for(MenuItem menuItem : menuItemList) {
            menuItems.add(menuItem.getMenuName());
//            System.out.println("Restraunt: "+ restraunt.getRestrauntName() +" MenuItem: " + menuItem.getMenuName());
        }

        return menuItems;
    }


    @Override
    public int bookReservation(String restrauntName, int desiredTableNumber){
        Restraunt restraunt = restrauntDao.getRestaurant(restrauntName);

        int allotedTableNumber = -1;
        if (restraunt != null) {
            allotedTableNumber = restraunt.bookTable(desiredTableNumber);
        }
        else {
            //throw exception
        }

        // add table number to userdata
        userDao.getCurrentLoginUser().setTable(new Table(allotedTableNumber, TableStatus.OCCUPIED));

        if(allotedTableNumber == -1) {
            System.out.println("No tables availaible right now.");
        }

        return allotedTableNumber;
    }

}
