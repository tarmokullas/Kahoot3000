package com.group4.Kahoot3000;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller

public class CreateGame {

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("createGameForm", new CreateGameForm());

        return "createGame";
    }


    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String createGameSubmit(Model model, @ModelAttribute("createGameForm") CreateGameForm createGameForm) {
       // long gamePin = addNewGame(createGameForm);
        addNewValur(createGameForm);
        return "createGame";
    }


    public static void addNewValur(CreateGameForm createGameForm) {
        String url = "jdbc:postgresql://localhost:5432/qmark";
        String user = "questionmark_admin";
        String password = "questionmark";

        String SQL = "INSERT INTO answers(content, correct)" + "VALUES(?,?)";
        String SQLquestion = "INSERT INTO questions(title,game)" + "VALUES(?, ?)";
        String SQLquestionID = "SELECT * FROM users";
        long gamePin = 1;


        int id = 0;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement question = connection.prepareStatement(SQLquestion, Statement.RETURN_GENERATED_KEYS)) {

            question.setString(1, createGameForm.getQuestion1());
            question.setLong(2, gamePin);
            int affectedRows = question.executeUpdate();


            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = question.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getInt(1);
                        System.out.println("id : " + id);
                        addNewAnswer(createGameForm, id);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());

                }
            }


        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(Database.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }


    }

    public static void addNewAnswer(CreateGameForm createGameForm, int questionID) {
        String url = "jdbc:postgresql://localhost:5432/qmark";
        String user = "questionmark_admin";
        String password = "questionmark";
        String SQL = "INSERT INTO answers(content, correct, question)" + "VALUES(?,?,?)";
        long id;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement answer = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            ArrayList<String> answers = new ArrayList<>();
            answers.add(createGameForm.getAnswer11());
            answers.add(createGameForm.getAnswer12());
            answers.add(createGameForm.getAnswer13());
            answers.add(createGameForm.getAnswer14());


            for (String a : answers) {
                answer.setString(1, a);
                answer.setBoolean(2, true);
                answer.setInt(3, questionID);
                int affectedRows = answer.executeUpdate();
                if (affectedRows > 0) {
                    // get the ID back
                    try (ResultSet rs = answer.getGeneratedKeys()) {
                        if (rs.next()) {
                            id = rs.getLong(1);
                            System.out.println("id : " + id);
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());

                    }
                }
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(Database.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

 /*   public static long addNewGame(CreateGameForm createGameForm) {
        String url = "jdbc:postgresql://localhost:5432/qmark";
        String user = "questionmark_admin";
        String password = "questionmark";
        String SQLgame = "INSERT INTO game(creator, name)" + "VALUES(?,?)";

        long id = 0;


        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement game = connection.prepareStatement(SQLgame, Statement.RETURN_GENERATED_KEYS)) {

            game.setInt(1, 1);
            game.setString(2, "mingi text");
            int affectedRows = game.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = game.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ext) {
                    System.out.println(ext.getMessage());
                }
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(Database.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return id;
    } */

}






 /*       try (Connection con = DriverManager.getConnection(url, user, password);

             PreparedStatement pstmt = con.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {


            pstmt.setString(1, createGameForm.getAnswer11());
            pstmt.setBoolean(2, true);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());

                }
            }


        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(Database.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } */



