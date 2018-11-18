package com.group4.Kahoot3000.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "games", schema = "public")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "creator")
    private Long creator;
    @Column(name = "name")
    private String name;


}
