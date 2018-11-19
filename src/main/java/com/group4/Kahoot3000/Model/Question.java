package com.group4.Kahoot3000.Model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions", schema = "public")
public class Question {

    //**********************//
    //     CLASS FIELDS     //
    //**********************//

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "game")
    private Long game;

    //*********************//
    //     CONSTRUCTOR     //
    //*********************//


    public Question(String title, Long game) {
        this.title = title;
        this.game = game;
    }

    //**************************//
    //     GETTERS & SETTERS    //
    //**************************//


    public Long getId() {
        return id;
    }
}
