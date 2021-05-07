package Order;

import Driver.Driver;
import Restaurant.Restaurant;
import User.User;

import java.util.*;

public class Order {
    protected String orderId;
    protected Restaurant restaurant;
    protected User user;
    protected Driver driver;


    protected List<String> products = new ArrayList<>();
    protected Set<String> oldID = new HashSet<>();

    public Order(Restaurant restaurant, User user, Driver driver) {
        this.restaurant = restaurant;
        this.user = user;
        this.driver = driver;
        this.orderId = this.IDgenerator();

        while(oldID.contains(this.orderId))
            this.orderId = this.IDgenerator();
        oldID.add(this.orderId);
    }

    private String IDgenerator(){
        Random number = new Random();
        return "ID" + number.nextInt(10000);
    }

    public String CSV(){
        return restaurant.CSV()+","+user.CSV()+","+driver.CSV();
    }
    
}
