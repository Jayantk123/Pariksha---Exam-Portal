package com.pariksha.controller;

import com.pariksha.model.Result;
import com.pariksha.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultService resultService;
//    add all result
    @PostMapping("/")
    public ResponseEntity<Result> addresult(@RequestBody Result result)
    {
        return ResponseEntity.ok(this.resultService.addresult(result));
    }

    @GetMapping("/")
    public ResponseEntity<?> getallResult()
    {
        return ResponseEntity.ok(this.resultService.getallResult());
    }


//    @DeleteMapping("/{uid}")
//    public void deletebyuid(@PathVariable("uid") Long uid)
//    {
//        this.resultService.deletebyrid(uid);
//    }

    @PutMapping("/")
    public Result update(@RequestBody Result result)
    {
        return this.resultService.updateresult(result);
    }
//    @GetMapping("/{uid}")
//    public ResponseEntity<Result> getbyuid(@PathVariable("uid") Long uid)
//    {
//        return ResponseEntity.ok(this.resultService.getresultbyuId(uid));
//    }

}
