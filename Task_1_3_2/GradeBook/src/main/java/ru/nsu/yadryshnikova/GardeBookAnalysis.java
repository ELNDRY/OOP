package ru.nsu.yadryshnikova;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GardeBookAnalysis {
    /**
     * Calculates the average of the grades.
     **/
    public static double AverageScore(ArrayList<Integer> grades) {
        double averageScore = 0.0;

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
    public static boolean isRedDiploma(GradeBook gradebook) {
        List<Integer> grades = new ArrayList<Integer>();
        grades = gradebook.getAllGrades();

        int totalScore = 0;
        boolean answer = true;
        for (int grade : grades) {
            if (grade < 4) {
                answer = false;
                break;
            }
            totalScore += grade;
        }
        if (totalScore / grades.size() < 0.75 || gradebook.getQualifyingWorkGrade() != 5)
            answer = false;
        return answer;
    }

    /**
     * @return true if the student have at least 50% of the highest grades,
     * There should be no “satisfactory" grades in the student's progress sheet.
     */
    public static boolean isIncreasedScholarship(GradeBook gradeBook, int semester) {
        Collection<Integer> grades = gradeBook.getSemesterGrades(semester);
        int totalScore = 0;
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

}
