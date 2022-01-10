package com.pariksha.repo;

import com.pariksha.model.exam.Category;
import com.pariksha.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
    Set<Quiz> findByCategory(Category category);

public List<Quiz> findByActive(Boolean b);

public List<Quiz> findByCategoryAndActive(Category c , Boolean b);

}
