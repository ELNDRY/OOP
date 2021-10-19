package ru.nsu.yadryshnikova;

import java.util.Map;

public class GradeBook {

    private int gradeBookNumber;
    private String studentName;
    private String faculty;
    private String specialty;
    private int qualifyingWorkGrade;

    public enum Grade {
        SATISFACTORY(3),
        GOOD(4),
        EXСELLENT(5);

        public final int value;

        Grade(int value) {
            this.value = value;
        }
    }

    public enum Subject {
        INTRODUCTION_TO_ALGEBRA_AND_ANALYSIS,
        INTRODUCTION_TO_DISCRETE_MATH_ANDMATHEMATICAL_LOGIC,
        DECLARATIVE_PROGRAMMING,
        IMPERATIVE_PROGRAMMING,
        FUNDAMENTALS_OF_SPEECH_CULTURE,
        FOREIGN_LANGUAGE,
        DIGITAL_PLATFORMS,
        MEASURING_WORKSHOP,
        HISTORY,
    }

    private Map<Subject, Grade[]> marks;
    private Grade qualificationWorkGrade;

    private int totalScore = 0;
    private int scoreAmount = 0;
    private int satisfactoryCount = 0;
    private int excellentCount = 0;
    private double averageScore = 0;

    public GradeBook(Map<Subject, Grade[]> marks, Grade qualificationWorkGrade, int gradeBookNumber, String studentName, String faculty, String specialty) {
        this.gradeBookNumber = gradeBookNumber;
        this.studentName = studentName;
        this.faculty = faculty;
        this.specialty = specialty;
        this.qualificationWorkGrade = qualificationWorkGrade;
        this.marks = marks;

        for(Map.Entry<Subject, Grade[]> entry : marks.entrySet()) {
            Grade[] grades = entry.getValue();
            for (Grade i : grades) {
                if (i.value == 3) {
                    satisfactoryCount += 1;
                } else if (i.value == 5) {
                    excellentCount += 1;
                }
                scoreAmount++;
                totalScore += i.value;
            }
        }
        averageScore =  totalScore / scoreAmount;
    }

    public void setSpecialty(int id) {
        this.specialty = specialty;
    }

    public double getAverageScore() {
        return averageScore;
    }
    public boolean isRedDiploma() {
        return satisfactoryCount == 0 && (double) excellentCount / totalScore >= 0.75 && qualificationWorkGrade == Grade.EXСELLENT;
    }
    public boolean isIncreasedScholarship() {
        return satisfactoryCount == 0 && excellentCount / totalScore >= 0.5;
    }
}
