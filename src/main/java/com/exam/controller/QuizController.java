package com.exam.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // add quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
        Quiz addedQuiz = this.quizService.addQuiz(quiz);

        return ResponseEntity.ok(addedQuiz);

    }

    // update quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
        Quiz updatedQuiz = this.quizService.updateQuiz(quiz);

        return ResponseEntity.ok(updatedQuiz);

    }

    // delete quiz
    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long quizId){
        this.quizService.deleteQuiz(quizId);

    }

    //get quiz by id
    @GetMapping("/{quizId}")
    public Quiz getQuiz(@PathVariable("quizId") Long quizId){
        return this.quizService.getQuiz(quizId);
    }

    // get all quizes
    @GetMapping("/")
    public ResponseEntity<Set<Quiz>> getAllQuiz(){
        return ResponseEntity.ok(this.quizService.getAllQuiz());
    }

    // get active quiz
    @GetMapping("/active")
    public ResponseEntity<?> getActiveQuiz(){
        return ResponseEntity.ok(this.quizService.getActiveQuiz());
    }

    // get active quiz
    @GetMapping("/category/{cid}")
    public ResponseEntity<?> getQuizByCategory(@PathVariable("cid") Long cid){
        Category category = new Category();
        category.setCatId(cid);
        return ResponseEntity.ok(this.quizService.getQuizOfCategory(category));
    }

    // get active quiz
    @GetMapping("/category/active/{cid}")
    public ResponseEntity<?> getQuizByActiveAndCtegory(@PathVariable("cid") Long cid){
        Category category = new Category();
        category.setCatId(cid);
        return ResponseEntity.ok(this.quizService.getActiveQuizOfCategory(category));
    }

}
