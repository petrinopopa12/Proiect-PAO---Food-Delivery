package User;


import Driver.Driver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserSingleton {
    private static UserSingleton instance;

    public static UserSingleton getInstance(){
        if(instance == null)
            instance = new UserSingleton();
        return instance;
    }

    private List<User> users = new ArrayList<User>();
    public void readCSV(){
        List<String[]> CSV = new ArrayList<>();
        try(var rawCSV = new BufferedReader(new FileReader("/Users/petrinopopa/Desktop/Proiect-PAO---Food-Delivery/proiectPAO/data/users.csv"))) {
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
            var newUser = new User(i[0],i[1],i[2]);
            users.add(newUser);
        }
    }

    public void writeCSV(){
        try{
            var outCSV = new FileWriter("/Users/petrinopopa/Desktop/Proiect-PAO---Food-Delivery/proiectPAO/data/users.csv");
            for (var i : this.users){
                outCSV.write(i.CSV());
                outCSV.write("\n");
                outCSV.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsers(){
        return users;
    }
    public void setUsers(List<User> users){
        this.users=users;
    }
}
