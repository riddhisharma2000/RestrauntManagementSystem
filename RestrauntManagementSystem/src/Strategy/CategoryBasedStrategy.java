package Strategy;

import model.MenuItem;
import model.Restraunt;

import java.util.ArrayList;
import java.util.List;

public class CategoryBasedStrategy implements RestrauntMenuDisplayStrategy {

    @Override
    public List<MenuItem> findRestrauntMenu(Restraunt restraunt) {
        List<MenuItem> menuItemList = restraunt.getMenu();


        List<MenuItem> categoryList = new ArrayList<>();
        for (MenuItem menuItem : menuItemList) {
            if (menuItem.getCategory() != null)
                categoryList.add(menuItem);
        }

        return menuItemList;
    }
}
