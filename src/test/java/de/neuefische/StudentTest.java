package de.neuefische;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentTest {
    @Test
    void whenIdAndNameGiven_thenInitialize () {
        // given
        String id = "abc";
        String name = "Bob";
        // when
        Student student = new Student(id, name);
        // then
        Assertions.assertEquals(new Student(id, name), student);
    }
}