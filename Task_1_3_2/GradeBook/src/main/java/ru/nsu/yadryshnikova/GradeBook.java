package ru.nsu.yadryshnikova;

import java.util.*;
import java.util.Collection;

public class GradeBook extends Semesters {

    final private int AMOUNT_OF_SEMESTERS = 9;
    private int gradeBookNumber;
    private String studentName;
    private String faculty;
    private String specialty;
    private int qualifyingWorkGrade;
    private final Semesters[] semesters = new Semesters[AMOUNT_OF_SEMESTERS];


    /**
     * GradeBook constructor.
     * semesters are counted from 1 to 8
     **/
    public GradeBook(int gradeBookNumber, int qualificationWorkGrade, String studentName, String faculty, String specialty) {
        this.gradeBookNumber = gradeBookNumber;
        this.studentName = studentName;
        this.faculty = faculty;
        this.specialty = specialty;
        this.qualifyingWorkGrade = qualificationWorkGrade;

        for (int i = 1; i < AMOUNT_OF_SEMESTERS; i++) {
            Semesters semester = new Semesters();
            semesters[i] = semester;
        }

    }

    /**
     * Set number of current gradebook.
     *
     * @param gradeBookNumber number of current gradebook.
     **/
    public void setGradeBookNumber(int gradeBookNumber) {
        this.gradeBookNumber = gradeBookNumber;
    }

    /**
     * Get number of current gradebook
     *
     * @return gradeBookNumber
     **/
    public int getGradeBookNumber() {
        return gradeBookNumber;
    }

    /**
     * Set name of the owner of the gradebook.
     *
     * @param gradeBookNumber number of current gradebook.
     **/
    public void setStudentName(int gradeBookNumber) {
        this.studentName = studentName;
    }

    /**
     * Get name of the owner of the gradebook
     *
     * @return studentName
     **/
    public String getStudentName() {
        return studentName;
    }

    /**
     * Set faculty of the owner of the gradebook.
     *
     * @param gradeBookNumber number of current gradebook.
     **/
    public void setFaculty(int gradeBookNumber) {
        this.faculty = faculty;
    }

    /**
     * Get faculty of the owner of the gradebook
     *
     * @return faculty
     **/
    public String getFaculty() {
        return faculty;
    }

    /**
     * Set specialty of the owner of the gradebook.
     *
     * @param gradeBookNumber number of current gradebook.
     **/
    public void setSpecialty(int gradeBookNumber) {
        this.specialty = specialty;
    }

    /**
     * Get specialty of the owner of the gradebook
     *
     * @return faculty *
     **/
    public String getSpecialty() {
        return specialty;
    }

    /**
     * Set qualifying work grade of the owner of the gradebook.
     *
     * @param gradeBookNumber number of current gradebook.
     **/
    public void setQualifyingWorkGrade(int gradeBookNumber) {
        this.qualifyingWorkGrade = qualifyingWorkGrade;
    }

    /**
     * Get qualifying work grade of the owner of the gradebook
     *
     * @return qualifyingWorkGrade
     **/
    public int getQualifyingWorkGrade() {
        return qualifyingWorkGrade;
    }

    /**
     * Add the name of the subject and the grade for it to the gradebook
     *
     * @param semester number of current semester.
     * @param subject  number name of the subject.
     * @param grade    grade for subject.
     **/
    public void add(int semester, String subject, int grade) {
        this.semesters[semester].setGrade(subject, grade);
    }

    /**
     * Get all grades in a given semester
     *
     * @param semesterCount number of given semester.
     * @return grades
     **/
    public Collection<Integer> getSemesterGrades(int semesterCount) {
        return semesters[semesterCount].getGrades();
    }

    /**
     * Get all grades
     *
     * @return all given grades
     **/
    public ArrayList<Integer> getAllGrades() {
        ArrayList<Integer> grades = new ArrayList<>();
        for (int i = 1; i < AMOUNT_OF_SEMESTERS; i++) {
            grades.addAll(semesters[i].getGrades());
        }
        return grades;
    }
}
