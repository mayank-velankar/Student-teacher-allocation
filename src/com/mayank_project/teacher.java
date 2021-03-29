package com.mayank_project;

public class teacher {
     private String id;
     private String subject;
      private int score;

    public boolean isIsfree() {
        return isfree;
    }

    public void setIsfree(boolean isfree) {
        this.isfree = isfree;
    }

    private boolean isfree;
    private String allotedSlot = null;

    public teacher(String id, String subject, int score, boolean isFree ) {
        this.id = id;
        this.subject = subject;
        this.score=score;
        this.isfree = isFree;
    }
    public int getMaxNumStud() {
        return maxNumStud;
    }

    public void setMaxNumStud(int maxNumStud) {
        this.maxNumStud = maxNumStud;
    }

    public int getMaxNumSessionDay() {
        return maxNumSessionDay;
    }

    public void setMaxNumSessionDay(int maxNumSessionDay) {
        this.maxNumSessionDay = maxNumSessionDay;
    }

    public int getMaxNumSessionMonth() {
        return maxNumSessionMonth;
    }

    public void setMaxNumSessionMonth(int maxNumSessionMonth) {
        this.maxNumSessionMonth = maxNumSessionMonth;
    }

    private  int maxNumStud =0;
    private int maxNumSessionDay=0;
    private  int maxNumSessionMonth =0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAllotedSlot() {
        return allotedSlot;
    }

    public void setAllotedSlot(String allotedSlot) {
        this.allotedSlot = allotedSlot;
    }

}