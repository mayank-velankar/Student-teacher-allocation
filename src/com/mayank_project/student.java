package com.mayank_project;

import java.util.Date;

public class student {
    private  String Id;
    private  String subject;
    private String slot;

    public student(String id, String subject, String slot) {
        Id = id;
        this.subject = subject;
        this.slot = slot;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
}
