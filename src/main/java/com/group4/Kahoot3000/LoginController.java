package com.group4.Kahoot3000;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Properties;


@Controller
public class LoginController {

    private static String userename;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("userForm", new UserForm());

        return "login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String loginSubmit(Model model, @ModelAttribute("userForm") UserForm userForm) {

        userename = userForm.getUsername();

        if(getUserPassword().equals(Hashing.sha256().hashString(userForm.getPassword() + getUserSalt(), StandardCharsets.UTF_8).toString())) {

            return "userpage";
        }

        return "redirect:login";
    }

    private static String getUserPassword() {
        String result = "";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "questionmark");
        props.setProperty("sslmode", "disable");
        //try (Connection connection = DriverManager.getConnection("jdbc:postgresql://85.253.216.148:5432/qmark", props)) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/qmark", props)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT username, password FROM users");
            while (resultSet.next()) {
                if (resultSet.getString("username").equals(userename)){

                    result = resultSet.getString("password");
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failure oops");
            e.printStackTrace();
        }
        return result;
    }

    private static String getUserSalt() {
        String result = "";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "questionmark");
        props.setProperty("sslmode", "disable");
        //try (Connection connection = DriverManager.getConnection("jdbc:postgresql://85.253.216.148:5432/qmark", props)) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/qmark", props)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT username, salt FROM users");
            System.out.println("check:  "+ resultSet.toString());
            while (resultSet.next()) {
                if (resultSet.getString("username").equals(userename)){

                    result = resultSet.getString("salt");
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failure oops");
            e.printStackTrace();
        }
        return result;
    }

}
