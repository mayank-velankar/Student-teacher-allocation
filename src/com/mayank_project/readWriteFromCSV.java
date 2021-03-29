package com.mayank_project;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class readWriteFromCSV {
    static List<teacher> readTeachersFromCSV(String fileName) {
        List<teacher> teachers = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                teacher t = createTeacher(attributes);
                teachers.add(t);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return teachers;
    }

    static List<student> readStudentFromCSV(String fileName) {
        List<student> students = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                student s = createStudent(attributes);
                students.add(s);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return students;
    }

    static void writeIntoCSV(ArrayList<allocation> a) throws IOException {
        FileWriter writer = new FileWriter("/Users/mv055935/Desktop/teacher_student_allocation/generatedBookings.csv");
        ArrayList<String[]> csvData = new ArrayList<>();

        for (allocation a1 : a) {
            int i = 0;
            String sID = a1.getSId();
            String subject = a1.getSubject();
            String slot =a1.getSlot();
            String tId =a1.gettId();
            String[] header = {sID, subject, slot, tId};
            csvData.add(header);
        }

        String[] header = {"StudentId", "Subject", "Slot", "TeacherId"};
        writer.write(Arrays.asList(header).stream().collect(Collectors.joining(",")));
        writer.write("\n"); // newline
        for (String s[] : csvData) {
            writer.write(Arrays.asList(s).stream().collect(Collectors.joining(",")));
            writer.write("\n"); // newline
        }

        writer.close();
}
    private static teacher createTeacher(String[] metadata)
    {
        String id = metadata[0];
        String subject = metadata[1];
        int score = Integer.parseInt(metadata[2]);
        return new teacher(id,subject,score,true);
    }

    private static student createStudent(String[] metadata)
    {   String id = metadata[0];
        String subject = metadata[1];
        String slot = metadata[2];
        return new student(id,subject,slot);
    }
}
