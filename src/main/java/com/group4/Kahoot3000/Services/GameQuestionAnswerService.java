package com.group4.Kahoot3000.Services;

import com.group4.Kahoot3000.Model.Answer;
import com.group4.Kahoot3000.Model.Game;
import com.group4.Kahoot3000.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameQuestionAnswerService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;


    public void addGame(Game game) {
        gameRepository.save(game);
    }

    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    public void addAnswer(Answer answer) {
        answerRepository.save(answer);
    }
}
