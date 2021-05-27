package DB;

import Restaurant.Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantDB {


    public void create(Restaurant rest){
        String sqlCode = "INSERT INTO Restaurant (name, address, owner) VALUES (?,?,?)";
        Connection conn = ConnectionDB.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sqlCode);
            statement.setString(1,rest.getName());
            statement.setString(2,rest.getAdress());
            statement.setString(3,rest.getOwner());
            statement.execute();
            System.out.println("restaurant added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Restaurant read(String name){
        String sqlCode = "SELECT * FROM Restaurant WHERE name=?";
        Connection conn = ConnectionDB.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sqlCode);
            statement.setString(1,name);
            ResultSet rs = statement.executeQuery();
            return rRest(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Restaurant rRest(ResultSet rs) throws SQLException {
        if(rs.next()){
            return new Restaurant(rs.getString(1), rs.getString(2),rs.getString(3));
        }
        return null;
    }

    private void update(String name, String adress, String owner){
        String sqlCode = "UPDATE Restaurant SET adress=?, owner=? WHERE name=?";
        Connection conn = ConnectionDB.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sqlCode);
            statement.setString(1,adress);
            statement.setString(2,owner);
            statement.setString(3,name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void delete(String name){
        String sqlCode = "DELETE FROM Restaurant WHERE name=?";
        Connection conn = ConnectionDB.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sqlCode);
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
