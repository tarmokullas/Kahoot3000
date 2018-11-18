package com.group4.Kahoot3000.Model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Answers", schema = "public")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "isCorrect")
    private Boolean isCorrect;
    @Column(name = "question")
    private Long question;

}
