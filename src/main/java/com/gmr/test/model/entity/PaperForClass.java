package com.gmr.test.model.entity;

import java.util.Date;

public class PaperForClass {
    private Integer id;

    private Integer papperId;

    private Integer classId;

    private String teacherId;

    private Date deadline;

    private Date startTime;

    private String limitTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPapperId() {
        return papperId;
    }

    public void setPapperId(Integer papperId) {
        this.papperId = papperId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime == null ? null : limitTime.trim();
    }
}