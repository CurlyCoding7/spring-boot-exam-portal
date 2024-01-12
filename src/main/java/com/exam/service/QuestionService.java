package com.exam.service;

import java.util.Set;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;

public interface QuestionService {

    Question addQuestion(Question question);

    Question updateQuestion(Question question);

    Set<Question> getQuestions();

    Question getQuestion(Long quesId);

    void deleteQuestion(Long quesId);

    Set<Question> getQuestionsOfQuiz(Quiz quiz);


}
