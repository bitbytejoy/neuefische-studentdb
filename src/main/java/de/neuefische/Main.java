package de.neuefische;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Student> students = Map.of(
                "1", new Student("1", "Bob"),
                "2", new Student("2", "Tom"),
                "3", new Student("3", "Jane")
        );

        StudentDB studentDB = new StudentDB(students);

        System.out.println(studentDB.randomStudent());
    }
}