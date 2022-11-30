package de.neuefische;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Student> students = new HashMap<>();
        students.put("1", new Student("1", "Bob"));
        students.put("2", new Student("2", "Tom"));
        students.put("3", new Student("3", "Jane"));

        StudentDB studentDB = new StudentDB(students);

        System.out.println(studentDB.randomStudent());
    }
}