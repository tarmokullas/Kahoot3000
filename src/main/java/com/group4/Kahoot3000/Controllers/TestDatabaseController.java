package com.group4.Kahoot3000.Controllers;


import com.group4.Kahoot3000.Model.User;
import com.group4.Kahoot3000.Forms.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


@Controller
public class TestDatabaseController {

    @RequestMapping(value = {"/testdatabase"}, method = RequestMethod.GET)
    public String testdatabase(Model model) {
        model.addAttribute("userForm", new UserForm());
        String databaseUserDump = getDatabaseUsers();
        String databaseGameDump = getDatabaseGames();
        String userCount = getUserCount();
        model.addAttribute("databaseuserdump", databaseUserDump);
        model.addAttribute("databasegamedump", databaseGameDump);
        model.addAttribute("usercount", userCount);
        return "testdatabase";
    }

    @RequestMapping(value = {"/testdatabase"}, method = RequestMethod.POST)
    public String userSubmit(Model model, @ModelAttribute("userForm") UserForm userForm) {

        User user = new User(userForm.getUsername(), userForm.getPassword());

        addUsertoDatabase(user);

        return "redirect:testdatabase";
    }

    //*********************//
    //     ABIMEETODID     //
    //*********************//

    private static String getDatabaseUsers() {
        String result = "";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "questionmark");
        props.setProperty("sslmode", "disable");
        //try (Connection connection = DriverManager.getConnection("jdbc:postgresql:// 85.253.216.65/qmark", props)) {
        try (Connection connection = DriverManager.getConnection(getAndmebaasString(), props)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                result += resultSet.getString("username") + " ";
            }
        } catch (SQLException e) {
            System.out.println("Connection failure oops");
            e.printStackTrace();
        }
        return result;
    }

    private static String getUserCount() {
        String result = "";
        Properties props = new Properties();
        props.setProperty("user", "hitensmrrhfrqu");
        props.setProperty("password", "85fda8baedba2a4b769d0c6b437789e0d9ed9dbb5a7b84b05ac2e9ec60be4b48");
        //try (Connection connection = DriverManager.getConnection("jdbc:postgresql://85.253.216.148:5432/qmark", props)) {
        try (Connection connection = DriverManager.getConnection(getAndmebaasString(), props)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");
            while (resultSet.next()) {
                result += resultSet.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Connection failure oops");
            e.printStackTrace();
        }
        return result;
    }

    private static String getDatabaseGames() {
        String result = "";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "questionmark");
        props.setProperty("sslmode", "disable");
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://85.253.216.148:5432/qmark", props)) {
            //try (Connection connection = DriverManager.getConnection(getAndmebaasString(), props)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, users.username FROM games JOIN users ON creator=users.id");
            while (resultSet.next()) {
                result += "Creator:" + resultSet.getString("username") + " , Name: " + resultSet.getString("name") + " ";
            }
        } catch (SQLException e) {
            System.out.println("Connection failure oops");
            e.printStackTrace();
        }
        return result;
    }

    public static void addUsertoDatabase(User user) {
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "questionmark");
        props.setProperty("sslmode", "disable");
        String query = "INSERT INTO public.users(\n" +
                "\tusername, password, salt)\n" +
                "\tVALUES ('" + user.getUsername() + "','" + user.getPassword() + "','" + user.getSalt() + "');";
        //try (Connection connection = DriverManager.getConnection("jdbc:postgresql://85.253.216.148:5432/qmark", props)) {
        try (Connection connection = DriverManager.getConnection(getAndmebaasString(), props)) {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("Connection failure oops");
            e.printStackTrace();
        }
    }

    public static String getAndmebaasString() {

        String andmebaasJBDC = "";

        try {
            Properties properties = new Properties();
            InputStream is = TestDatabaseController.class.getClassLoader().getResourceAsStream("application.properties");
            if (is != null) {
                properties.load(is);
                // TODO close the stream
            } else {
                // Properties file not found!
                System.out.println("Properties file not found!");
            }
            andmebaasJBDC = properties.getProperty("spring.datasource.url");
            return properties.getProperty("spring.datasource.url");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Property not found!");
            return "Property not found";
        }

    }
}
