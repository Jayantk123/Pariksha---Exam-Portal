package com.pariksha.service;

import com.pariksha.model.Result;

import java.util.Set;

public interface ResultService {

//    addresult
    public Result addresult(Result result);

//    get all result

    public Set<Result> getallResult();

//    getresult by userid

    public Result getresultbyuId(Long userid);

//    update result

    public Result updateresult(Result result);

//    delete result by rid

    public void deletebyrid(Long rid);
}
