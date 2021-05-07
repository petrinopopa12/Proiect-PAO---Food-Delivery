package Restaurant;


import Driver.Driver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantSingleton {
    private static RestaurantSingleton instance;

    public static RestaurantSingleton getInstance(){
        if(instance == null)
            instance = new RestaurantSingleton();
        return instance;
    }

    private List<Restaurant> restaurants = new ArrayList<Restaurant>();
    public void readCSV(){
        List<String[]> CSV = new ArrayList<>();
        try(var rawCSV = new BufferedReader(new FileReader("/Users/petrinopopa/Desktop/Proiect-PAO---Food-Delivery/proiectPAO/data/restaurants.csv"))) {
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
            var newRestaurant = new Restaurant(i[0],i[1],i[2],Integer.parseInt(i[3]));
            restaurants.add(newRestaurant);
        }
    }

    public void writeCSV(){
        try{
            var outCSV = new FileWriter("/Users/petrinopopa/Desktop/Proiect-PAO---Food-Delivery/proiectPAO/data/restaurants.csv");
            for (var i : this.restaurants){
                outCSV.write(i.CSV());
                outCSV.write("\n");
                outCSV.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Restaurant> getRestaurants(){
        return restaurants;
    }
    public void setRestaurants(List<Restaurant> restaurants){
        this.restaurants=restaurants;
    }
}
