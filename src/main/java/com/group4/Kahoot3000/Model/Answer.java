package com.group4.Kahoot3000.Model;


import javax.persistence.*;

@Entity
@Table(name = "Answers", schema = "public")
public class Answer {

    //**********************//
    //     CLASS FIELDS     //
    //**********************//

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "Correct")
    private Boolean correct;

    @Column(name = "question")
    private Long question;

    //*********************//
    //     CONSTRUCTOR     //
    //*********************//

    public Answer(String content, Long question) {
        this.content = content;
        this.question = question;
        this.correct = false;
    }

    //**************************//
    //     GETTERS & SETTERS    //
    //**************************//

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
