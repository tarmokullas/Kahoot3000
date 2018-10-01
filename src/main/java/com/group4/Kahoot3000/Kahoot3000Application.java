package com.group4.Kahoot3000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Kahoot3000Application {
	public static void main(String[] args) {
        testDatabase();
		SpringApplication.run(Kahoot3000Application.class, args);
	}

	public static void testDatabase() {
	    try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/qmark", "questionmark_admin", "questionmark")) {
	        Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("Connection failure oops");
            e.printStackTrace();
        }

    }
}
