package com.gmr.test.model.entity;

public class Paper {
    private Integer paperId;

    private String teacherId;

    private String paperName;

    private Integer probleNum;

    private Integer paperScore;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName == null ? null : paperName.trim();
    }

    public Integer getProbleNum() {
        return probleNum;
    }

    public void setProbleNum(Integer probleNum) {
        this.probleNum = probleNum;
    }

    public Integer getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(Integer paperScore) {
        this.paperScore = paperScore;
    }
}