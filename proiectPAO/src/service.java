import Driver.Driver;
import Restaurant.Restaurant;
import User.User;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class service {
    private List<Restaurant> restaurants = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();
    private int nrRest;
    private int nrUser;
    private int nrDriv;

    public void addRestaurant(Scanner in) throws ParseException{
        this.restaurants.add(Restaurant.addRestaurant(in));
        nrRest++;
        System.out.println("Restaurant added.");
    }

    public void addUser(Scanner in) throws ParseException{
        this.users.add(User.addUser(in));
        nrUser++;
        System.out.println("User added.");
    }

    public void addDriver(Scanner in) throws ParseException{
        this.drivers.add(Driver.addDriver(in));
        nrDriv++;
        System.out.println("Driver added.");
    }

    private Restaurant getRest(Scanner in){
        System.out.println("Restaurant's id: ");
        var id = Integer.parseInt(in.nextLine());
        return restaurants.get(id);
    }

    private User getUser(Scanner in){
        System.out.println("User's id: ");
        var id = Integer.parseInt(in.nextLine());
        return users.get(id);
    }

    private Driver getDriv(Scanner in){
        System.out.println("Driver's id: ");
        var id = Integer.parseInt(in.nextLine());
        return drivers.get(id);
    }

    public void showRestaurant(Scanner in) {
        var rest = this.getRest(in);
        System.out.println(rest.toString());
    }

    public void showUser(Scanner in) {
        var user = this.getUser(in);
        System.out.println(user.toString());
    }

    public void showDriver(Scanner in) {
        var driv = this.getDriv(in);
        System.out.println(driv.toString());
    }

    public void showRestaurantAdress(Scanner in) {
        var rest = this.getRest(in);
        System.out.println(rest.getAdress());
    }

    public void showRestaurantName(Scanner in) {
        var rest = this.getRest(in);
        System.out.println(rest.getName());
    }

    public void showUserAdress(Scanner in) {
        var user = this.getUser(in);
        System.out.println(user.getAdress());
    }

    public void showIfCar(Scanner in) {
        var driv = this.getDriv(in);
        System.out.println(driv.ifCar());
    }
}
