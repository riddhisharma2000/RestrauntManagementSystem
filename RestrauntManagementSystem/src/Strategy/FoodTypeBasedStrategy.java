package Strategy;

import enums.FoodType;
import model.MenuItem;
import model.Restraunt;

import java.util.*;

public class FoodTypeBasedStrategy implements RestrauntMenuDisplayStrategy{
    @Override
    public List<MenuItem> findRestrauntMenu(Restraunt restraunt){
        List<MenuItem> menuItemList = restraunt.getMenu();


        List<MenuItem> foodTypeList =  new ArrayList<>();
        for(MenuItem menuItem : menuItemList)
        {
            if(menuItem.getFoodType() != null)
            foodTypeList.add(menuItem);
        }

        return menuItemList;


        // if we plan to do for pricing
//        Collections.sort(menuItemList, new Comparator<MenuItem>() {
//            @Override
//            public int compare(MenuItem menuItem1, MenuItem menuItem2) {
//                return FoodType.compare(menuItem1.)
//            }
//        });
    }
}
