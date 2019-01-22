package com.yxp.springboot.bean;

public class StudentAnswer {
    private Integer questionId;

    private String studentId;

    private String selectAnswer;

    private String secondSelect;

    private String answer;

    private String analyse;

    public StudentAnswer(Integer questionId, String studentId, String selectAnswer, String secondSelect, String answer) {
        this.questionId = questionId;
        this.studentId = studentId;
        this.selectAnswer = selectAnswer;
        this.secondSelect = secondSelect;
        this.answer = answer;
    }

    public StudentAnswer(Integer questionId, String studentId, String selectAnswer, String secondSelect, String answer, String analyse) {
        this.questionId = questionId;
        this.studentId = studentId;
        this.selectAnswer = selectAnswer;
        this.secondSelect = secondSelect;
        this.answer = answer;
        this.analyse = analyse;
    }

    public StudentAnswer() {
        super();
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getSelectAnswer() {
        return selectAnswer;
    }

    public void setSelectAnswer(String selectAnswer) {
        this.selectAnswer = selectAnswer == null ? null : selectAnswer.trim();
    }

    public String getSecondSelect() {
        return secondSelect;
    }

    public void setSecondSelect(String secondSelect) {
        this.secondSelect = secondSelect == null ? null : secondSelect.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getAnalyse() {
        return analyse;
    }

    public void setAnalyse(String analyse) {
        this.analyse = analyse == null ? null : analyse.trim();
    }
}