package com.group4.Kahoot3000;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    public static void main(String[] args) {

        Database a = new Database();
        a.getActorCount();

    }

    public void getActorCount() {
        String url = "jdbc:postgresql://localhost:5432/qmark";
        String user = "questionmark_admin";
        String password = "questionmark";
        String SQL = "INSERT INTO users(username,password, salt)" + "VALUES(?,?,?)";
        String SQL_test = "SELECT * FROM users";
        long id = 0;
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_test)) {
            while (rs.next()) {
                String count = rs.getString(2);
                String count2 = rs.getString(3);
                System.out.println(count + "   " + count2 );
            }

  /*           PreparedStatement pstmt = con.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, "sergeiTest");
            pstmt.setString(2, "eensaluTest");
            pstmt.setString(3,"1e15a927250f2167fefdf19d401b60ce226d25208f5a46aa9932e9c57521116c");

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            } */


        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(Database.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }


  /*      String SQL = "SELECT count(*) FROM actor";
        int count = 0;

        try (Connection conn = con();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return count;
    }
 */
    }
}
