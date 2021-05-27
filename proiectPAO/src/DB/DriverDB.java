package DB;

import Driver.Driver;
import Restaurant.Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverDB {
    public void create(Driver driv){
        String sqlCode = "INSERT INTO Driver (first_name, last_name) VALUES (?,?)";
        Connection conn = ConnectionDB.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sqlCode);
            statement.setString(1,driv.getFirstName());
            statement.setString(2,driv.getLastName());

            statement.execute();
            System.out.println("driver added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Driver read(String fname){
        String sqlCode = "SELECT * FROM Driver WHERE first_name=?";
        Connection conn = ConnectionDB.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sqlCode);
            statement.setString(1,fname);
            ResultSet rs = statement.executeQuery();
            return rRest(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Driver rRest(ResultSet rs) throws SQLException {
        if(rs.next()){
            return new Driver(rs.getString(1), rs.getString(2));
        }
        return null;
    }

    private void update(String fname, String lname){
        String sqlCode = "UPDATE Driver SET last_name=? WHERE first_name=?";
        Connection conn = ConnectionDB.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sqlCode);
            statement.setString(1,lname);
            statement.setString(2,fname);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void delete(String fname){
        String sqlCode = "DELETE FROM Driver WHERE first_name=?";
        Connection conn = ConnectionDB.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sqlCode);
            statement.setString(1, fname);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
