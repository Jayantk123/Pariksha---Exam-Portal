package com.pariksha.controller;


import com.pariksha.model.exam.Category;
import com.pariksha.model.exam.Question;
import com.pariksha.model.exam.Quiz;
import com.pariksha.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

//    addddd
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

//    get all quiz
    @GetMapping("/")
    public ResponseEntity<?> getQuizzes()
    {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

//    get quiz by id
    @GetMapping("/{quizId}")
    public Quiz getQuiz(@PathVariable("quizId") Long quizId)
    {
        return this.quizService.getQuiz(quizId);
    }

//    update quiz
    @PutMapping("/")
    public Quiz updateQuiz(@RequestBody Quiz quiz)
    {
        return this.quizService.updateQuiz(quiz);
    }

//    delete quiz
    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long quizId)
    {
        this.quizService.deleteQuiz(quizId);

    }

//    get quiz by categoryId
    @GetMapping("/category/{cid}")
    public ResponseEntity<?> getQuizbyCatId(@PathVariable("cid")Long cid)
    {
        Category category = new Category();
        category.setCid(cid);


        Set<Quiz> quizofcategory = this.quizService.getQuizbyCatid(category);
        return ResponseEntity.ok(quizofcategory);

    }


//    get active quizes
    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes()
    {
        return this.quizService.getActiveQuizzes();
    }

    //    get active quizes of category
    @GetMapping("/category/active/{cid}")
    public List<Quiz> getActiveQuizzesOfcategory(@PathVariable("cid") Long cid)
    {

        Category category = new Category();
        category.setCid(cid);
        return this.quizService.getActiveQuizzesOfCategory(category);
    }

}
