package Order;


import Restaurant.Restaurant;
import User.User;
import Driver.Driver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderSingleton {
    private static OrderSingleton instance;

    public static OrderSingleton getInstance(){
        if(instance == null)
            instance = new OrderSingleton();
        return instance;
    }

    private List<Order> orders = new ArrayList<Order>();
    public void readCSV(){
        List<String[]> CSV = new ArrayList<>();
        try(var rawCSV = new BufferedReader(new FileReader("/Users/petrinopopa/Desktop/Proiect-PAO---Food-Delivery/proiectPAO/data/orders.csv"))) {
            String i;
            i = rawCSV.readLine();
            while(i != null){
                String[] line = i.split(",");
                CSV.add(line);
                i = rawCSV.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("no csv file");
        } catch (IOException e) {
            System.out.println("empty file");
        }

        for (var i : CSV){
            var newOrder = new Order(new Restaurant(i[0],i[1],i[2],Integer.parseInt(i[3])),
                                     new User(i[4],i[5],i[6]),
                                     new Driver(i[7],i[8],Boolean.parseBoolean(i[9])));
            orders.add(newOrder);
        }
    }

    public void writeCSV(){
        try{
            var outCSV = new FileWriter("/Users/petrinopopa/Desktop/Proiect-PAO---Food-Delivery/proiectPAO/data/orders.csv");
            for (var i : this.orders){
                outCSV.write(i.CSV());
                outCSV.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getOrders(){
        return orders;
    }
    public void setOrders(List<Order> orders){
        this.orders=orders;
    }
}
