package com.gmr.test.model.entity;

public class StudentsAnswer {
    private Integer id;

    private Integer paperId;

    private String studentsAnswer;

    private Integer problemId;

    private Integer problemType;

    private Integer isRight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getStudentsAnswer() {
        return studentsAnswer;
    }

    public void setStudentsAnswer(String studentsAnswer) {
        this.studentsAnswer = studentsAnswer == null ? null : studentsAnswer.trim();
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getProblemType() {
        return problemType;
    }

    public void setProblemType(Integer problemType) {
        this.problemType = problemType;
    }

    public Integer getIsRight() {
        return isRight;
    }

    public void setIsRight(Integer isRight) {
        this.isRight = isRight;
    }
}