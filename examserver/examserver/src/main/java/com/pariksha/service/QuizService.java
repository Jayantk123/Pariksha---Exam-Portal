package com.pariksha.service;

import com.pariksha.model.exam.Category;
import com.pariksha.model.exam.Quiz;

import java.util.List;
import java.util.Set;

public interface QuizService {


    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizzes();

    public Quiz getQuiz(Long quizId);

    public void deleteQuiz(Long quizId);

//    get quiz by category id
    public Set<Quiz> getQuizbyCatid(Category category);

//get all active quizes
    public List<Quiz> getActiveQuizzes();

//    get all active quizes of category
    public List<Quiz> getActiveQuizzesOfCategory(Category c);
}
