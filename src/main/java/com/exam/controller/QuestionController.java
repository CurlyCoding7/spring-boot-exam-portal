package com.exam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    // add question
    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        Question addedQuestion = this.questionService.addQuestion(question);

        return ResponseEntity.ok(addedQuestion);

    }

    // update question
    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        Question updatedQ = this.questionService.updateQuestion(question);

        return ResponseEntity.ok(updatedQ);

    }

    // delete question
    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") Long questionId){
        this.questionService.deleteQuestion(questionId);

    }

    //get question by id
    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable("questionId") Long questionId){
        return this.questionService.getQuestion(questionId);
    }

    // get all questions by quiz
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("quizId") Long quizId){

        Quiz quiz = this.quizService.getQuiz(quizId);
        Set<Question> questions = quiz.getQuestions();

        List list = new ArrayList<>(questions);

        if(list.size() > quiz.getNoOfQuestions()){
            list = list.subList(0, quiz.getNoOfQuestions() + 1);

        }

        Collections.shuffle(list);

        return ResponseEntity.ok(list);
    }

    // get all questions by quiz
    @GetMapping("/quiz/all/{quizId}")
    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("quizId") Long quizId){
        Quiz quiz = new Quiz();
        quiz.setQId(quizId);
        Set<Question> questionOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionOfQuiz);

      
    }

    // evaluate quiz
    @PostMapping("/quiz/all/{quizId}")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
        
        double gotMarks = 0;
        int correctAnswers = 0;
        int atempted = 0;

        for(Question q : questions){

            Question question = this.questionService.getQuestion(q.getQuesId());

            if(question.getAnswer().equals(q.getGivenAnswer())){

                // correct
                correctAnswers++;

                double singleMarks = questions.get(0).getQuiz().getMaxMarks() / questions.size();
                gotMarks += singleMarks;

            }

            if(q.getGivenAnswer() != null || !q.getGivenAnswer().equals("")){
                atempted++;
            }

        }

        Map<String, Object> map = Map.of("gotMarks", gotMarks, "correctAnswers", correctAnswers, "attempted", atempted);

        return ResponseEntity.ok(map);

      
    }

    


}
