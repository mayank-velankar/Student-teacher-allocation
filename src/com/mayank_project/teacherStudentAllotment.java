package com.mayank_project;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.*;

public class teacherStudentAllotment {
    public static ArrayList<allocation> createAllotment(int N, int M, int K, List<student> s, List<teacher> t) {
        ArrayList<allocation> result = new ArrayList<>();
        for (student list : s) {
            String teacherId = fetchBestTeacher(list.getSubject(), list.getSlot(), t, N, M, K);
            allocation newAlloc = new allocation(list.getId(), list.getSubject() , list.getSlot(), teacherId);
            result.add(newAlloc);

        }
        return result;
    }

    public static String fetchBestTeacher(String subject, String slot, List<teacher> t, int N, int M, int K) {
        // sorting the teachers based on subject and proficiency
        Collections.sort(t, new Comparator<teacher>() {
            @Override
            public int compare(teacher o1, teacher o2) {
                if(o1.getSubject().equals(o2.getSubject())) {
                    if (o1.getScore() < o2.getScore())
                        return 1;
                    else
                        return -1;
                } else {
                    return o1.getSubject().compareTo(o2.getSubject());
                }

            }
        });

        for (teacher t1 : t) {
            try {
                DateFormat f = new SimpleDateFormat("yyyy-mm-dd hh:mm");
                if (t1.getAllotedSlot() != null) {
                    Date slot1 = f.parse(t1.getAllotedSlot());
                    Date slot2 = f.parse(slot);
                    String outOfSlot = slot.substring(11,13);

                    // check if the slot exist out of scope
                    if(Integer.parseInt(outOfSlot) > 16)
                        return "None";

                    if (slot1.before(slot2) && t1.getSubject().equals(subject)) {
                        t1.setIsfree(true);
                        t1.setMaxNumStud(t1.getMaxNumStud()-1);
                        t1.setMaxNumSessionDay(0);
                    }
                    else if(slot1.equals(slot2) && t1.getSubject().equals(subject) && t1.getMaxNumStud()<N){
                        t1.setIsfree(true);
                        t1.setMaxNumSessionMonth(t1.getMaxNumSessionMonth()-1);
                    }
                }

            } catch(ParseException e){
                e.printStackTrace();
            }
            if (t1.getSubject().equals(subject)  && t1.getMaxNumStud() < N && t1.getMaxNumSessionDay() < M && t1.getMaxNumSessionMonth() < K) {
                if (t1.isIsfree()) {
                    t1.setMaxNumStud(t1.getMaxNumStud() + 1);
                    t1.setMaxNumSessionDay(t1.getMaxNumSessionDay()+1);
                    t1.setMaxNumSessionMonth(t1.getMaxNumSessionMonth()+1);
                    t1.setAllotedSlot(slot);
                    t1.setIsfree(false);

                    return t1.getId();
                }
                }
            }

        return "None";
    }
}



