package com.pariksha.controller;

import com.pariksha.model.exam.Question;
import com.pariksha.model.exam.Quiz;
import com.pariksha.service.QuestionService;
import com.pariksha.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

//    addd
    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question)
    {
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

//    get all question
//    @GetMapping("/")
//   public ResponseEntity<?> getQuestions()
//    {
//        return ResponseEntity.ok(this.questionService.getQuestions());
//    }

//    get ques by id
    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable("questionId") Long questionId)
    {
        return this.questionService.getQuestion(questionId);
    }

//    update
    @PutMapping("/")
    public Question updateQuestion(@RequestBody Question question)
    {
        return this.questionService.updateQuestion(question);
    }

//    delete
    @DeleteMapping("/{quesId}")
    public void deleteQuestion(@PathVariable("quesId") Long quesId)
    {
        this.questionService.deleteQuestion(quesId);

    }

//    get ques by quizez id
    @GetMapping("/quiz/{qid}")
public ResponseEntity<?> getQuestionsofQuiz(@PathVariable("qid") Long qid)
    {

//        Quiz quiz = new Quiz();
//        quiz.setqId(qid);
//        Set<Question> questionsOfQuiz = this.questionService.getQuestionsofQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);

        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question>questions = quiz.getQuestions();
        List<Question> list = new ArrayList(questions);
        if(list.size()>Integer.parseInt(quiz.getNumberofQuestions()))
        {
            list = list.subList(0,Integer.parseInt(quiz.getNumberofQuestions()+1));

        }
        list.forEach((q)->{
            q.setAns("");
        });
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }



//    all ques by quiz id
@GetMapping("/quiz/all/{qid}")
public ResponseEntity<?> getQuestionsofQuizAdmin(@PathVariable("qid") Long qid)
{

        Quiz quiz = new Quiz();
        quiz.setqId(qid);
        Set<Question> questionsOfQuiz = this.questionService.getQuestionsofQuiz(quiz);
        return ResponseEntity.ok(questionsOfQuiz);


    
}


//evaluate quiz
    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions)
    {
        System.out.println(questions);
        double marksGot=0;
        int correctAnswers=0;
        int attempted=0;
        int totalques=0;

        int totalmarks=0;
        double singlem=Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();

      for(Question q:questions){
            
//            System.out.println(q.getGivenAnswer());
          totalques++;
          Question question = this.questionService.get(q.getQuesId());
        if(question.getAns().equals(q.getGivenAnswer()))
        {
//            correct
            correctAnswers++;
                 double singlemarks=Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();

marksGot+=singlemarks;

        }
        if( q.getGivenAnswer()!=null)
        {
attempted++;
        }
        };

      totalmarks=(totalques)*(int)singlem;
      Map<String,Object>map = Map.of("marksGot",marksGot,"correctAnswers",correctAnswers,"Attempted",attempted, "Totalques",totalques,"Totalmarks",totalmarks);
//      System.out.println(attempted);
        return ResponseEntity.ok(map);
    }


}
