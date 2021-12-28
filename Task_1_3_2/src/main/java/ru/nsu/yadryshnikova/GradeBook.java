package ru.nsu.yadryshnikova;

import java.util.*;
import java.util.Collection;

public class GradeBook {

    final private int AMOUNT_OF_SEMESTERS = 8;
    private int gradeBookNumber;
    private String studentName;
    private String faculty;
    private String specialty;
    private int qualifyingWorkGrade;
    private final Semesters[] semesters = new Semesters[AMOUNT_OF_SEMESTERS];


    /**
     * GradeBook constructor.
     **/
    public GradeBook(int gradeBookNumber, int qualificationWorkGrade, String studentName, String faculty, String specialty) {
        this.gradeBookNumber = gradeBookNumber;
        this.studentName = studentName;
        this.faculty = faculty;
        this.specialty = specialty;
        this.qualifyingWorkGrade = qualificationWorkGrade;

        for (int i = 0; i < AMOUNT_OF_SEMESTERS; i++) {
            Semesters semester = new Semesters();
            semesters[i] = semester;
        }

    }

    public double averageScore() {
        double averageScore = 0.0;
        List<Integer> grades = new ArrayList<Integer>();
        grades = getAllGrades();
        for (int grade : grades) {
            averageScore += grade;
        }

        averageScore /= grades.size();
        averageScore = (double) Math.round(averageScore * 100) / 100;
        return averageScore;
    }

    /**
     * @return true if the student have at least 75% of the highest grades,
     * There should be no “satisfactory" grades in the student's progress sheet,
     * qualification work grade is "excellent".
     */
    public boolean isRedDiploma() {
        List<Integer> grades = new ArrayList<Integer>();
        grades = getAllGrades();

        double totalScore = 0.0;
        boolean answer = true;
        for (int grade : grades) {
            if (grade < 4) {
                answer = false;
                break;
            }
            totalScore += grade;
        }
        if (totalScore / grades.size() < 0.75 || getQualifyingWorkGrade() != 5)
            answer = false;
        return answer;
    }

    /**
     * @return true if the student have at least 50% of the highest grades,
     * There should be no “satisfactory" grades in the student's progress sheet.
     */
    public boolean isIncreasedScholarship(int semester) {
        Collection<Integer> grades = getSemesterGrades(semester);
        double totalScore = 0;
        boolean answer = true;
        for (int grade : grades) {
            if (grade < 4) {
                answer = false;
                break;
            }
            totalScore += grade;
        }
        if (totalScore / grades.size() < 0.5)
            answer = false;
        return answer;
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
    public void setStudentName(String studentName) {
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
     * @param faculty of current gradebook.
     **/
    public void setFaculty(String faculty) {
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
     * @param specialty of the owner of the gradebook.
     **/
    public void setSpecialty(String specialty) {
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
     * @param qualifyingWorkGrade of current gradebook.
     **/
    public void setQualifyingWorkGrade(int qualifyingWorkGrade) {
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
        this.semesters[semester-1].setGrade(subject, grade);
    }

    /**
     * Get all grades in a given semester
     *
     * @param semesterCount number of given semester.
     * @return grades
     **/
    public Collection<Integer> getSemesterGrades(int semesterCount) {
        return semesters[semesterCount-1].getGrades();
    }

    /**
     * Get all grades
     *
     * @return all given grades
     **/
    public ArrayList<Integer> getAllGrades() {
        ArrayList<Integer> grades = new ArrayList<>();
        for (int i = 0; i < AMOUNT_OF_SEMESTERS; i++) {
            grades.addAll(semesters[i].getGrades());
        }
        return grades;
    }
}
