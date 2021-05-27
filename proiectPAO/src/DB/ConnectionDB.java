package DB;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionDB {

    private static final String url = "jdbc:postgresql://localhost/paoproject";
    private static final String user = "postgres";
    private static final String password = "Petrino123*";

    private static Connection connect;

    public static Connection getConnection() {
        try {
            if(connect.isClosed() || connect == null) {
            connect = DriverManager.getConnection(url, user, password);
            if(connect != null){
            System.out.println("Connected to the PostgreSQL server successfully.");}}
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connect;
    }

    public static void disconnect() {
        try{
            if (!connect.isClosed() && connect!=null){
                connect.close();
                System.out.println("Disconnected");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private ConnectionDB(){ }
}
