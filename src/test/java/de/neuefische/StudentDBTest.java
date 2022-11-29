package de.neuefische;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentDBTest {
    @Test
    void whenInitializedWithStudentArray_thenSuccess () {
        // given
        Student[] students = {new Student("1", "Bob"), new Student("2", "Tom"), new Student("3", "Jane")};
        // when
        StudentDB actual = new StudentDB(students);
        // then
        Assertions.assertEquals(
            new StudentDB(new Student[]{new Student("1", "Bob"), new Student("2", "Tom"), new Student("3", "Jane")}),
            actual
        );
    }

    @Test
    void whenGetStudents_thenReturnAllStudents () {
        // given
        StudentDB studentDB = new StudentDB(new Student[]{
            new Student("1", "Bob"),
            new Student("2", "Tom"),
            new Student("3", "Jane")
        });
        // when
        Student[] actual = studentDB.getStudents();
        // then
        Assertions.assertArrayEquals(
            new Student[]{
                new Student("1", "Bob"),
                new Student("2", "Tom"),
                new Student("3", "Jane")
            },
            actual
        );
    }

    @Test
    void whenToString_thenFormatAsString () {
        // given
        StudentDB studentDB = new StudentDB(new Student[]{
                new Student("1", "Bob"),
                new Student("2", "Tom"),
        });
        // when
        String actual = studentDB.toString();
        // then
        Assertions.assertEquals(
            "StudentDB(students=[Student(id=1, name=Bob), Student(id=2, name=Tom)])",
            actual
        );
    }

    @Test
    void whenAddStudent_thenAllStudentsContainsStudent () {
        // given
        StudentDB studentDB = new StudentDB(new Student[]{
                new Student("1", "Bob"),
                new Student("2", "Tom"),
        });
        // when
        studentDB.add(new Student("3", "Jane"));
        // then
        Assertions.assertEquals(
            new StudentDB(new Student[]{
                new Student("1", "Bob"),
                new Student("2", "Tom"),
                new Student("3", "Jane")
            }),
            studentDB
        );
    }

    @Test
    void whenRemoveStudentById_thenAllStudentsDoesNotContainStudent () {
        // given
        StudentDB studentDB = new StudentDB(new Student[]{
                new Student("1", "Bob"),
                new Student("2", "Tom"),
                new Student("3", "Jane")
        });
        // when
        studentDB.remove("2");
        // then
        Assertions.assertEquals(
                new StudentDB(new Student[]{
                        new Student("1", "Bob"),
                        new Student("3", "Jane")
                }),
                studentDB
        );
    }
}