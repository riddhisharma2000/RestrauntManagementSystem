package Strategy;

import model.MenuItem;
import model.Restraunt;

import java.util.List;

public interface RestrauntMenuDisplayStrategy {
    public List<MenuItem> findRestrauntMenu(Restraunt restraunt);
}
