package ru.nsu.yadryshnikova;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Semesters {

    private final Map<String, Integer> semester = new HashMap<String, Integer>();

    Semesters() {
    }

    protected void setGrade(String subject, int grade) {
        this.semester.put(subject, grade);
    }

    protected Collection<Integer> getGrades() {
        return this.semester.values();
    }

    protected Collection<String> getSubject() {
        return this.semester.keySet();
    }

}
