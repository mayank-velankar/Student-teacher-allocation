package com.mayank_project;

import java.util.ArrayList;

public class allocation {
    private String SId;
    private String subject;
    private String slot;
    private  String tId;


    public allocation(String SId, String subject, String slot, String tId) {
        this.SId = SId;
        this.subject = subject;
        this.slot = slot;
        this.tId = tId;
    }

    public String getSId() {
        return SId;
    }

    public void setSId(String SId) {
        this.SId = SId;
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

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }
}
