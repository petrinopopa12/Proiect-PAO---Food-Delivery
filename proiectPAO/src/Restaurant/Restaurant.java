package Restaurant;

import java.text.ParseException;
import java.util.Scanner;

public class Restaurant {
    protected String name;
    protected String adress;
    protected String owner;
    protected int employeesNumber;


    public Restaurant(String name, String adress, String owner, int employeesNumber) {
        this.name = name;
        this.adress = adress;
        this.owner = owner;
        this.employeesNumber = employeesNumber;
    }

    public Restaurant(Scanner in) throws ParseException  {
        this.read(in);
    }

    public static Restaurant addRestaurant(Scanner in) throws ParseException {
        return new Restaurant(in);
    }

    public void read(Scanner in){
        System.out.println("Restaurant name: ");
        this.name = in.nextLine();
        System.out.println("Location: ");
        this.adress = in.nextLine();
        System.out.println("Owner's name: ");
        this.owner = in.nextLine();
        System.out.println("Number of employees: ");
        this.employeesNumber = Integer.parseInt(in.nextLine());
    }

    public String getAdress(){
        return adress;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "["+"name= "+name+", adress= "+adress+", owner= "+owner+", employees_nr= "+employeesNumber+"]";
    }
}
