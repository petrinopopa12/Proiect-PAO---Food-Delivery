package Driver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DriverSingleton {
    private static DriverSingleton instance;

    public static DriverSingleton getInstance(){
        if(instance == null)
            instance = new DriverSingleton();
        return instance;
    }

    private List<Driver> drivers = new ArrayList<Driver>();
    public void readCSV(){
        List<String[]> CSV = new ArrayList<>();
        try(var rawCSV = new BufferedReader(new FileReader("/Users/petrinopopa/Desktop/Proiect-PAO---Food-Delivery/proiectPAO/data/drivers.csv"))) {
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
            var newDriver = new Driver(i[0],i[1],Boolean.parseBoolean(i[2]));
            drivers.add(newDriver);
        }
    }

    public void writeCSV(){
        try{
            var outCSV = new FileWriter("/Users/petrinopopa/Desktop/Proiect-PAO---Food-Delivery/proiectPAO/data/drivers.csv");
            for (var i : this.drivers){
                outCSV.write(i.CSV());
                outCSV.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Driver> getDrivers(){
        return drivers;
    }
    public void setDrivers(List<Driver> drivers){
        this.drivers=drivers;
    }
}
