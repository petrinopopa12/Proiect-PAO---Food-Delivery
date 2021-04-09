package User;

import Order.Order;
import Restaurant.Restaurant;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class User {
    protected String firstName;
    protected String lastName;
    protected String adress;
    protected long cardNumber;
    protected Date expDate;
    protected int cvv;

    protected List<Order> orderHistory = new ArrayList<>();

    public User(String firstName, String lastName, String adress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
    }

    public User(Scanner in) throws ParseException {
        this.read(in);
    }

    public static User addUser(Scanner in) throws ParseException {
        return new User(in);
    }

    public void read(Scanner in){
        System.out.println("First name: ");
        this.firstName = in.nextLine();
        System.out.println("Last name: ");
        this.lastName = in.nextLine();
        System.out.println("Adress: ");
        this.adress = in.nextLine();
    }

    public String getAdress(){
        return adress;
    }

    @Override
    public String toString(){
        return "["+" first name= "+firstName+", last name= "+lastName+", adress= "+adress+"]";
    }
}
