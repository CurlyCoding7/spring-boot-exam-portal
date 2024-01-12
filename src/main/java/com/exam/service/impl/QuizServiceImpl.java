package com.exam.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.repo.QuizRepo;
import com.exam.service.QuizService;

@Service
public class QuizServiceImpl  implements QuizService{

    @Autowired
    private QuizRepo quizRepo;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepo.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepo.save(quiz);
    }

    @Override
    public void deleteQuiz(Long quizId) {
        Quiz quiz = new Quiz();
        quiz.setQId(quizId);
        this.quizRepo.delete(quiz);
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepo.findById(quizId).get();
    }

    @Override
    public Set<Quiz> getAllQuiz() {
        return new HashSet<>(this.quizRepo.findAll());
    }

    @Override
    public List<Quiz> getQuizOfCategory(Category category) {
        return this.quizRepo.findByCategory(category);
    }

    @Override
    public List<Quiz> getActiveQuiz() {
        return this.quizRepo.findByActive(true);
    }

    @Override
    public List<Quiz> getActiveQuizOfCategory(Category category) {
        return this.quizRepo.findByActiveAndCategory(category, true);
    }

}
