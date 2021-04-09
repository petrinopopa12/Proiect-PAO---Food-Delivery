package Order;

import Driver.Driver;
import Restaurant.Restaurant;
import User.User;

public class Pickup extends Order{
    public Pickup(Restaurant restaurant, User user, Driver driver) {
        super(restaurant, user, driver);
    }
}
