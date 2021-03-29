package com.mayank_project;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.mayank_project.readWriteFromCSV.writeIntoCSV;

public class Main {

    public static void main(String[] args) {
        // write your code here

        List<teacher> teachers = readWriteFromCSV.readTeachersFromCSV("/Users/mv055935/Desktop/teacher_student_allocation/teachers.csv");
        List<student> students = readWriteFromCSV.readStudentFromCSV("/Users/mv055935/Desktop/teacher_student_allocation/student_requests.csv");
        System.out.println("Enter Maximum number of students allowed in session ");
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        System.out.println("Enter maximum number of sessions a teacher can take in Day ");
        int M = Integer.parseInt(in.nextLine());
        System.out.println("Enter maximum number of sessions a teacher can take in Month ");
        int K = Integer.parseInt(in.nextLine());
        ArrayList<allocation> allocatedResult = new ArrayList<>();
        students.remove(0);
        // sort student list based on the time
        Collections.sort(students, new Comparator<student>() {
            @Override
            public int compare(student d1, student d2){
                try {
                    DateFormat f = new SimpleDateFormat("yyyy-mm-dd hh:mm");
                    return f.parse(d1.getSlot()).compareTo(f.parse(d2.getSlot()));
                }
                catch (Exception e){
                    throw new IllegalArgumentException(e);
                }
            }
        });
        allocatedResult= teacherStudentAllotment.createAllotment(N,M,K,students,teachers);
        //sorting the allocation to be written in CSV
        Collections.sort(allocatedResult, new Comparator<allocation>() {
            @Override
            public int compare(allocation o1, allocation o2) {
                    return o1.getSId().compareTo(o2.getSId());
                }

        });
        try {
            writeIntoCSV(allocatedResult);
            System.out.println("Allotment Done, Please check the CSV :)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

