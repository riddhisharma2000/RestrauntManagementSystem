package dao;

import enums.UserType;
import exceptions.RestrauntNotPresentException;
import model.Restraunt;
import model.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestrauntDao {
   private static RestrauntDao restrauntDaoInstance;
    private HashMap<String, Restraunt> restaurantMap;

    private RestrauntDao(){
        this.restaurantMap = new HashMap<>();
    }

    public static RestrauntDao getInstance() {
        if(restrauntDaoInstance == null)
        {
            restrauntDaoInstance = new RestrauntDao();
        }
        return restrauntDaoInstance;
    }

    public void addRestaurant(Restraunt restraunt) {
        if (this.restaurantMap.containsKey(restraunt.getRestrauntName())) {
            //  throw new RestaurantAlreadyPresent("restaurant Already present");
        }
        this.restaurantMap.put(restraunt.getRestrauntName(), restraunt);
    }

    public Restraunt getRestaurant(String restrauntName) {
        if (!restaurantMap.containsKey(restrauntName)) {
           // throw new RestaurantNotPresent("restaurant Not Present");
        }
        return restaurantMap.get(restrauntName);
    }



//    public void addRestaurant(String restrauntName, UserType userType, int numberOfTables) {
//        this.restraunt = new Restraunt(restrauntName, UserType.ADMIN, numberOfTables);
//
//    }

    public List<Restraunt> getListOfRestaurants() {
        List<Restraunt> list = new ArrayList<>();
        for (Map.Entry<String, Restraunt> entry : restaurantMap.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }


    //addRestrant
    // updateRestraunt
    //getListOFrestraunt


}
