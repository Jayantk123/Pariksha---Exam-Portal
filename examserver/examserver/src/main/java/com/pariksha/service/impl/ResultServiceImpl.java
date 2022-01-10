package com.pariksha.service.impl;

import com.pariksha.model.Result;
import com.pariksha.repo.ResultRepository;
import com.pariksha.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public Result addresult(Result result) {
        return this.resultRepository.save(result);
    }

    @Override
    public Set<Result> getallResult() {
        return new HashSet<>(this.resultRepository.findAll());
    }

    @Override
    public Result getresultbyuId(Long userid) {
        return (Result) this.resultRepository.findByuserid(userid);
    }

    @Override
    public Result updateresult(Result result) {
        return this.resultRepository.save(result);
    }

    @Override
    public void deletebyrid(Long rid) {
this.resultRepository.deleteById(rid);
    }
}
