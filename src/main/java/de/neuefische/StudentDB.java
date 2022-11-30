package de.neuefische;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class StudentDB {
    private Map<String, Student> students;

    public Student randomStudent () {
        Set<String> keys = students.keySet();
        String[] keysArray = (String[])keys.toArray();
        String randomKey = keysArray[(int) (Math.random() * keysArray.length)];

        return students.get(randomKey);
    }

    public void add(Student student) {
        students.put(student.getId(), student);
    }

    public void remove(String id) {
        students.remove(id);
    }
}
