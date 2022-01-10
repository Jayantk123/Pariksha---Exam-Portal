package com.pariksha.repo;

import com.pariksha.model.Result;
import com.pariksha.service.QuestionService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ResultRepository extends JpaRepository<Result,Long> {


    Set<Result> findByuserid(Long userid);

}
