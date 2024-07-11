import model.MenuItem;
import services.RestrauntAdminService;
import services.RestrauntAdminServiceImpl;
import services.RestrauntCustomerService;
import services.RestrauntCustomerServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        RestrauntAdminService adminService = new RestrauntAdminServiceImpl();
        RestrauntCustomerService userService = new RestrauntCustomerServiceImpl();

        adminService.registerRestraunt("Kapoor's Cafe", 10, "Admin");
        adminService.displayTableStatus("Kapoor's Cafe");
        adminService.addMenuItems("Kapoor's Cafe", "Spaghetti Carbonara",
                499, "Veg" , "Main_Course");
        adminService.addMenuItems("Kapoor's Cafe", "Cheeseburger",
                1000, "Non_Veg" , "Starter");
        adminService.addMenuItems("Kapoor's Cafe", "French Fries",
                300, "Veg" , "Starter");
        adminService.addMenuItems("Kapoor's Cafe", "Pizza",
                3000, "Veg" , "Main_Course");
        adminService.updateMenuItems("Kapoor's Cafe","Cheeseburger", 1500);

        adminService.removeMenuItem("Kapoor's Cafe", "Pizza");

        List<String> menuItemsList = adminService.viewMenuItems("Kapoor's Cafe");

        for (String menuItem : menuItemsList) {
            System.out.println("kapoor's Cafe" +" MenuItem: " + menuItem);
        }

        List<MenuItem> menuItemsListBasedOnFoodType =
                userService.viewRestrauntMenu("Kapoor's Cafe", "foodtype", "customer");
        List<MenuItem> menuItemsListBasedOnCategory =
                userService.viewRestrauntMenu("Kapoor's Cafe", "category", "customer");


        System.out.println("FoodType Based List: ");

        for (MenuItem menuItem : menuItemsListBasedOnFoodType) {
            System.out.println("kapoor's Cafe: FoodType" +" MenuItem: " + menuItem.getMenuName());
        }

        System.out.println("Category Based List: ");

        for (MenuItem menuItem : menuItemsListBasedOnCategory) {
            System.out.println("kapoor's Cafe: Category" +" MenuItem: " + menuItem.getMenuName());
        }


       // userService.addItemsToOrder();



//        4.	Allocate an empty table to the customer (e.g., Allocate Table)
//        5.	Mark the table as occupied and then vacant after bill payment.
//        6.	Make a reservation for a specific table (e.g., Reserve Table Number “7”)
//        7.	Display the status of all tables to show changes.
//        8.	Browse the menu with / without filters (veg / non-veg, category) and add items to an order (e.g., add "2 Margherita Pizza" and "1 Caesar Salad").
//        9.	Remove an item from the order (e.g., remove "1 Caesar Salad").
//        10.	Change the quantity of an item in the order (e.g., change the quantity of "Margherita Pizza" to 3).
//        11.	Place the order.
//        12.	Customers can ask for the bill. Get preferred payment type and calculate and show the total bill for an order with different items and quantities.
//•	Apply taxes and any additional charges to the bill based on payment type selected by customer


    }
}