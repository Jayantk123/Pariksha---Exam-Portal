package com.pariksha.model;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rid;

    private Long userid;
    private String username;
    private String firstname;
    private String lastname;
    private Long catid;
    private String catname;
    private Long quizid;
    private String quizname;
    private Long totalmarks;
    private Long marksgot;
    private Long totalques;
    private Long quesatt;
    private Long correctans;


    public Result() {
    }

    public Result(Long rid, Long userid, String username, String firstname, String lastname, Long catid, String catname, Long quizid, String quizname, Long totalmarks, Long marksgot, Long totalques, Long quesatt, Long correctans) {
        this.rid = rid;
        this.userid = userid;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.catid = catid;
        this.catname = catname;
        this.quizid = quizid;
        this.quizname = quizname;
        this.totalmarks = totalmarks;
        this.marksgot = marksgot;
        this.totalques = totalques;
        this.quesatt = quesatt;
        this.correctans = correctans;
    }


    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getCatid() {
        return catid;
    }

    public void setCatid(Long catid) {
        this.catid = catid;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public Long getQuizid() {
        return quizid;
    }

    public void setQuizid(Long quizid) {
        this.quizid = quizid;
    }

    public String getQuizname() {
        return quizname;
    }

    public void setQuizname(String quizname) {
        this.quizname = quizname;
    }

    public Long getTotalmarks() {
        return totalmarks;
    }

    public void setTotalmarks(Long totalmarks) {
        this.totalmarks = totalmarks;
    }

    public Long getMarksgot() {
        return marksgot;
    }

    public void setMarksgot(Long marksgot) {
        this.marksgot = marksgot;
    }

    public Long getTotalques() {
        return totalques;
    }

    public void setTotalques(Long totalques) {
        this.totalques = totalques;
    }

    public Long getQuesatt() {
        return quesatt;
    }

    public void setQuesatt(Long quesatt) {
        this.quesatt = quesatt;
    }

    public Long getCorrectans() {
        return correctans;
    }

    public void setCorrectans(Long correctans) {
        this.correctans = correctans;
    }

    @Override
    public String toString() {
        return "Result{" +
                "rid=" + rid +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", catid=" + catid +
                ", catname='" + catname + '\'' +
                ", quizid=" + quizid +
                ", quizname='" + quizname + '\'' +
                ", totalmarks=" + totalmarks +
                ", marksgot=" + marksgot +
                ", totalques=" + totalques +
                ", quesatt=" + quesatt +
                ", correctans=" + correctans +
                '}';
    }
}
