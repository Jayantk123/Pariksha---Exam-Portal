package com.pariksha.service.impl;

import com.pariksha.model.exam.Category;
import com.pariksha.model.exam.Quiz;
import com.pariksha.repo.QuizRepository;
import com.pariksha.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {

this.quizRepository.deleteById(quizId);
    }

    @Override
    public Set<Quiz> getQuizbyCatid(Category category) {
        return this.quizRepository.findByCategory(category);
    }



//get active quizzes
@Override
public List<Quiz> getActiveQuizzes() {
    return this.quizRepository.findByActive(true);
}

    @Override
    public List<Quiz> getActiveQuizzesOfCategory(Category c) {
        return this.quizRepository.findByCategoryAndActive(c,true);
    }
}
