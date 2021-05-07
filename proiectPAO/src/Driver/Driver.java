package Driver;

import User.User;

import java.text.ParseException;
import java.util.Scanner;

public class Driver {
    protected String firstName;
    protected String lastName;
    protected boolean isCar;

    public Driver(String firstName, String lastName, boolean isCar){
        this.firstName = firstName;
        this.lastName = lastName;
        this.isCar = isCar;
    }

    public Driver(Scanner in) throws ParseException {
        this.read(in);
    }

    public static Driver addDriver(Scanner in) throws ParseException {
        return new Driver(in);
    }

    public void read(Scanner in){
        System.out.println("First name: ");
        this.firstName = in.nextLine();
        System.out.println("Last name: ");
        this.lastName = in.nextLine();
        System.out.println("Has a car?: ");
        this.isCar = Boolean.valueOf(in.nextLine());
    }

    public Boolean ifCar(){
        return isCar;
    }

    @Override
    public String toString(){
        return "["+" first name= "+firstName+", last name= "+lastName+", Car= "+isCar+"]";
    }

    public String CSV(){
        return firstName+","+lastName+","+isCar;
    }
}
