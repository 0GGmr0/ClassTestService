package com.gmr.test.model.entity;

import java.util.Date;

public class StudentsPaper {
    private Integer studentsPaperId;

    private Integer papperId;

    private String studentId;

    private String studentName;

    private Integer studentScore;

    private String correctRate;

    private Integer isSubmit;

    private Date submitTime;

    public Integer getStudentsPaperId() {
        return studentsPaperId;
    }

    public void setStudentsPaperId(Integer studentsPaperId) {
        this.studentsPaperId = studentsPaperId;
    }

    public Integer getPapperId() {
        return papperId;
    }

    public void setPapperId(Integer papperId) {
        this.papperId = papperId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public Integer getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(Integer studentScore) {
        this.studentScore = studentScore;
    }

    public String getCorrectRate() {
        return correctRate;
    }

    public void setCorrectRate(String correctRate) {
        this.correctRate = correctRate == null ? null : correctRate.trim();
    }

    public Integer getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(Integer isSubmit) {
        this.isSubmit = isSubmit;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }
}