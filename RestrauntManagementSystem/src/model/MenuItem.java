package model;

import enums.Category;
import enums.FoodType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MenuItem {

    private final String menuItemName;
    private double price;
    private FoodType foodType;
    private Category category;
    private int inventory;

    public MenuItem(String menuName, double price, FoodType foodType, Category category)
    {

        this.menuItemName = menuName;
        this.price = price;
        foodType = foodType;
        category = category;

    }

    public MenuItem(String menuName, double price)
    {

        this.menuItemName = menuName;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    public String getMenuName() {
        return menuItemName;
    }

    public void addInventory(int amount)
    {
        inventory = amount;
    }

    public boolean isAvailaible()
    {
        if(inventory > 0)
        {
            return true;
        }
        return false;
    }

    public  FoodType getFoodType() {
        return foodType;
    }

    public void updateInventory(int items) {
        inventory -= items;
    }

    public  Category getCategory() {
        return category;
    }
}
