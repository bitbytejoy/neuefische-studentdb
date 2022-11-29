package de.neuefische;

public class Main {
    public static void main(String[] args) {
        StudentDB studentDB = new StudentDB(new Student[]{
                new Student("1", "Bob"),
                new Student("2", "Tom"),
                new Student("3", "Jane")
        });

        System.out.println(studentDB.randomStudent());
    }
}