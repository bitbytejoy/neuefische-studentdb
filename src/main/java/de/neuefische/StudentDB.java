package de.neuefische;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDB {
    private Student[] students;

    public Student randomStudent () {
        if (students.length < 1) {
            return null;
        }

        return students[(int) (Math.random() * students.length)];
    }

    public void add(Student student) {
        Student[] newStudents = new Student[students.length + 1];

        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];
        }

        newStudents[newStudents.length - 1] = student;

        students = newStudents;
        // Arrays.copyOf
    }

    public void remove(String id) {
        Student[] newStudents = new Student[students.length - 1];

        int j = 0;
        for (int i = 0; i < students.length; i++) {
            if (!students[i].getId().equals(id)) {
                newStudents[j] = students[i];
                j++;
            }
        }

        students = newStudents;
    }
}
