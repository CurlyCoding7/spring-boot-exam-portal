package com.exam.service;

import java.util.List;
import java.util.Set;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;

public interface QuizService {

    Quiz addQuiz(Quiz quiz);

    Quiz updateQuiz(Quiz quiz);

    void deleteQuiz(Long quizId);

    Quiz getQuiz(Long quizId);

    Set<Quiz> getAllQuiz();

    List<Quiz> getQuizOfCategory(Category category);

    List<Quiz> getActiveQuiz();

    List<Quiz> getActiveQuizOfCategory(Category category);


}
