import java.util.Locale;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        service serv = new service();
        Scanner in = new Scanner(System.in);
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
                }
            } catch (Exception e){
                System.out.println(e.toString());
            }
        }
    }
}
