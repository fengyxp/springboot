package com.yxp.springboot.bean;

public class StudentScore {
    private String studentId;

    private Integer score;

    private Integer secondScore;

    private Integer totalScore;

    private String result;

    private Integer threshold;

    public StudentScore(String studentId, Integer score, Integer secondScore, Integer totalScore, String result, Integer threshold) {
        this.studentId = studentId;
        this.score = score;
        this.secondScore = secondScore;
        this.totalScore = totalScore;
        this.result = result;
        this.threshold = threshold;
    }

    public StudentScore() {
        super();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getSecondScore() {
        return secondScore;
    }

    public void setSecondScore(Integer secondScore) {
        this.secondScore = secondScore;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }
}