package com.group4.Kahoot3000.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "games", schema = "public")
public class Game {

    //**********************//
    //     CLASS FIELDS     //
    //**********************//

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "creator")
    private Long creator;
    @Column(name = "name")
    private String name;

    //*********************//
    //     CONSTRUCTOR     //
    //*********************//

    public Game(Long creator, String name) {
        this.creator = creator;
        this.name = name;
    }

    public Game(String name) {
        this.name = name;
    }

    //***************************//
    //     CETTERS & SETTERS     //
    //***************************//

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }
}
