import Driver.DriverSingleton;
import Order.OrderSingleton;
import Restaurant.RestaurantSingleton;
import User.UserSingleton;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        service serv = new service();
        audit aud = new audit();
        Scanner in = new Scanner(System.in);

        DriverSingleton.getInstance().readCSV();
        serv.setDrivers(DriverSingleton.getInstance().getDrivers());
        OrderSingleton.getInstance().readCSV();
        serv.setOrders(OrderSingleton.getInstance().getOrders());
        RestaurantSingleton.getInstance().readCSV();
        serv.setRestaurants(RestaurantSingleton.getInstance().getRestaurants());
        UserSingleton.getInstance().readCSV();
        serv.setUsers(UserSingleton.getInstance().getUsers());

        int x = 0;
        while (x == 0){
            System.out.println("Command: ");
            String c = in.nextLine().toLowerCase(Locale.ROOT);
            try{
                switch (c){
                    case "add_restaurant" -> serv.addRestaurant(in);
                    case "add_user" -> serv.addUser(in);
                    case "add_driver" -> serv.addDriver(in);
                    case "get_restaurant" -> serv.showRestaurant(in);
                    case "get_user" -> serv.showUser(in);
                    case "get_driver" -> serv.showDriver(in);
                    case "restaurant_adress" -> serv.showRestaurantAdress(in);
                    case "restaurant_name" -> serv.showRestaurantName(in);
                    case "user_adress" -> serv.showUserAdress(in);
                    case "driver_car" -> serv.showIfCar(in);
                    case "end" -> x=1;
                }aud.Audit(c);
            } catch (Exception e){
                System.out.println(e.toString());
            }
        }

        DriverSingleton.getInstance().setDrivers(serv.getDrivers());
        DriverSingleton.getInstance().writeCSV();
        OrderSingleton.getInstance().setOrders(serv.getOrders());
        OrderSingleton.getInstance().writeCSV();
        RestaurantSingleton.getInstance().setRestaurants(serv.getRestaurants());
        RestaurantSingleton.getInstance().writeCSV();
        UserSingleton.getInstance().setUsers(serv.getUsers());
        UserSingleton.getInstance().writeCSV();
    }
}
