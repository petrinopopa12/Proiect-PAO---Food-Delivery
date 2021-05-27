package DB;

import Restaurant.Restaurant;
import User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {

    public void create(User rest){
        String sqlCode = "INSERT INTO User (first_name, last_name, address) VALUES (?,?,?)";
        Connection conn = ConnectionDB.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sqlCode);
            statement.setString(1,rest.getFirstName());
            statement.setString(2,rest.getLastName());
            statement.setString(3,rest.getAdress());
            statement.execute();
            System.out.println("user added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User read(String name){
        String sqlCode = "SELECT * FROM User WHERE first_name=?";
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

    private User rRest(ResultSet rs) throws SQLException {
        if(rs.next()){
            return new User(rs.getString(1), rs.getString(2),rs.getString(3));
        }
        return null;
    }

    private void update(String fname, String lname, String address){
        String sqlCode = "UPDATE User SET last_name=?, address=? WHERE first_name=?";
        Connection conn = ConnectionDB.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sqlCode);
            statement.setString(1,lname);
            statement.setString(2,address);
            statement.setString(3,fname);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void delete(String name){
        String sqlCode = "DELETE FROM User WHERE first_name=?";
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
