package com.group4.Kahoot3000.Controllers;

import com.group4.Kahoot3000.Forms.*;
import com.group4.Kahoot3000.Model.Answer;
import com.group4.Kahoot3000.Model.Game;
import com.group4.Kahoot3000.Model.Question;
import com.group4.Kahoot3000.Services.GameQuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class CreateController {

    GameQuestionAnswerService GQAservice;

    @Autowired
    public CreateController(GameQuestionAnswerService GQAservice) {
        this.GQAservice = GQAservice;
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("createGameForm", new CreateGameForm());

        return "create";
    }


    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String createGameSubmit(Model model, @ModelAttribute("createGameForm") CreateGameForm createGameForm) {

        Game game = new Game(22L, createGameForm.getGameName());
        //game.setCreator( LOGGED IN USER LONG ID);
        GQAservice.addGame(game);

        // Sorry for hard-coding. TODO make it shorter

        //------QUESTIONS-----//

        Question question1 = new Question(createGameForm.getQuestion1(), game.getId());
        Question question2 = new Question(createGameForm.getQuestion2(), game.getId());


        GQAservice.addQuestion(question1);
        GQAservice.addQuestion(question2);


        //------ANSWERS-----//

        Answer answer11 = new Answer(createGameForm.getAnswer11(), question1.getId());
        Answer answer12 = new Answer(createGameForm.getAnswer12(), question1.getId());
        Answer answer13 = new Answer(createGameForm.getAnswer13(), question1.getId());
        Answer answer14 = new Answer(createGameForm.getAnswer14(), question1.getId());

        String trueAnswer1 = createGameForm.getQuestion1trueAnswer();

        switch (trueAnswer1) {
            case "11":
                answer11.setCorrect(true);
                break;
            case "12":
                answer12.setCorrect(true);
                break;
            case "13":
                answer13.setCorrect(true);
                break;
            case "14":
                answer14.setCorrect(true);
                break;
        }

        GQAservice.addAnswer(answer11);
        GQAservice.addAnswer(answer12);
        GQAservice.addAnswer(answer13);
        GQAservice.addAnswer(answer14);

        Answer answer21 = new Answer(createGameForm.getAnswer21(), question2.getId());
        Answer answer22 = new Answer(createGameForm.getAnswer22(), question2.getId());
        Answer answer23 = new Answer(createGameForm.getAnswer23(), question2.getId());
        Answer answer24 = new Answer(createGameForm.getAnswer24(), question2.getId());

        String trueAnswer2 = createGameForm.getQuestion2trueAnswer();

        switch (trueAnswer2) {
            case "21":
                answer21.setCorrect(true);
                break;
            case "22":
                answer22.setCorrect(true);
                break;
            case "23":
                answer23.setCorrect(true);
                break;
            case "24":
                answer24.setCorrect(true);
                break;
        }

        GQAservice.addAnswer(answer21);
        GQAservice.addAnswer(answer22);
        GQAservice.addAnswer(answer23);
        GQAservice.addAnswer(answer24);


        return "userpage";
    }





}

