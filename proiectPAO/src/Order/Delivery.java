package Order;

import Driver.Driver;
import Restaurant.Restaurant;
import User.User;

public class Delivery extends Order{
    public Delivery(Restaurant restaurant, User user, Driver driver) {
        super(restaurant, user, driver);
    }
}
