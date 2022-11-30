package de.neuefische;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class StudentDBTest {
    @Test
    void whenInitializedWithStudentArray_thenSuccess () {
        // given
        Map<String, Student> students = new HashMap<>();
        students.put("1", new Student("1", "Bob"));
        students.put("2", new Student("2", "Tom"));
        students.put("3", new Student("3", "Jane"));
        // when
        StudentDB actual = new StudentDB(students);
        // then
        Assertions.assertEquals(
            new StudentDB(Map.of(
                "1", new Student("1", "Bob"),
                "2", new Student("2", "Tom"),
                "3", new Student("3", "Jane")
            )),
            actual
        );
    }

    @Test
    void whenGetStudents_thenReturnAllStudents () {
        // given
        Map<String, Student> students = new HashMap<>();
        students.put("1", new Student("1", "Bob"));
        students.put("2", new Student("2", "Tom"));
        students.put("3", new Student("3", "Jane"));
        StudentDB studentDB = new StudentDB(students);
        // when
        Map<String, Student> actual = studentDB.getStudents();
        // then
        Assertions.assertEquals(
            Map.of(
                "1", new Student("1", "Bob"),
                "2", new Student("2", "Tom"),
                "3", new Student("3", "Jane")
            ),
            actual
        );
    }

    @Test
    void whenToString_thenFormatAsString () {
        // given
        Map<String, Student> students = new HashMap<>();
        students.put("1", new Student("1", "Bob"));
        students.put("2", new Student("2", "Tom"));
        StudentDB studentDB = new StudentDB(students);
        // when
        String actual = studentDB.toString();
        // then
        Assertions.assertEquals(
            "StudentDB(students={1=Student(id=1, name=Bob), 2=Student(id=2, name=Tom)})",
            actual
        );
    }

    @Test
    void whenAddStudent_thenAllStudentsContainsStudent () {
        // given
        Map<String, Student> students = new HashMap<>();
        students.put("1", new Student("1", "Bob"));
        students.put("2", new Student("2", "Tom"));
        StudentDB studentDB = new StudentDB(students);
        // when
        studentDB.add(new Student("3", "Jane"));
        // then
        Assertions.assertEquals(
            new StudentDB(Map.of(
                "1", new Student("1", "Bob"),
                "2", new Student("2", "Tom"),
                "3", new Student("3", "Jane")
            )),
            studentDB
        );
    }

    @Test
    void whenRemoveStudentById_thenAllStudentsDoesNotContainStudent () {
        // given
        Map<String, Student> students = new HashMap<>();
        students.put("1", new Student("1", "Bob"));
        students.put("2", new Student("2", "Tom"));
        students.put("3", new Student("3", "Jane"));
        StudentDB studentDB = new StudentDB(students);
        // when
        studentDB.remove("2");
        // then
        Assertions.assertEquals(
                new StudentDB(Map.of(
                    "1", new Student("1", "Bob"),
                    "3", new Student("3", "Jane")
                )),
                studentDB
        );
    }
}