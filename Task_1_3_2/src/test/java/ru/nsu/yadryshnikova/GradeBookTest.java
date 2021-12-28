package ru.nsu.yadryshnikova;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.*;

class GradeBookTest {

    @Test
    void getAverageScore() throws IOException {
        GradeBook gradeBook = new GradeBook(200613, 4, "Yadryshnikova E.E.", "FIT", "Computer science and engineering");
        gradeBook.add(1, "INTRODUCTION_TO_ALGEBRA_AND_ANALYSIS", 3);
        gradeBook.add(2, "INTRODUCTION_TO_ALGEBRA_AND_ANALYSIS", 3);
        gradeBook.add(2, "INTRODUCTION_TO_DISCRETE_MATH_AND_MATHEMATICAL_LOGIC", 4);
        gradeBook.add(1, "DECLARATIVE_PROGRAMMING", 5);
        gradeBook.add(1, "FUNDAMENTALS_OF_SPEECH_CULTURE", 5);
        gradeBook.add(1, "FOREIGN_LANGUAGE", 5);
        gradeBook.add(2, "FOREIGN_LANGUAGE", 5);


        assertEquals(4.29, gradeBook.averageScore());
    }

    @Test
    void isRedDiploma() {
        GradeBook gradeBook = new GradeBook(200613, 4, "Yadryshnikova E.E.", "FIT", "Computer science and engineering");
        gradeBook.add(1, "INTRODUCTION_TO_ALGEBRA_AND_ANALYSIS", 3);
        gradeBook.add(2, "INTRODUCTION_TO_ALGEBRA_AND_ANALYSIS", 3);
        gradeBook.add(2, "INTRODUCTION_TO_DISCRETE_MATH_AND_MATHEMATICAL_LOGIC", 4);
        gradeBook.add(1, "DECLARATIVE_PROGRAMMING", 5);
        gradeBook.add(1, "FUNDAMENTALS_OF_SPEECH_CULTURE", 5);
        gradeBook.add(1, "FOREIGN_LANGUAGE", 5);
        gradeBook.add(2, "FOREIGN_LANGUAGE", 5);

        assertFalse(gradeBook.isRedDiploma());
    }

    @Test
    void isIncreasedScholarship() {

        GradeBook gradeBook = new GradeBook(200613, 4, "Yadryshnikova E.E.", "FIT", "Computer science and engineering");
        gradeBook.add(1, "INTRODUCTION TO ALGEBRA AND ANALYSIS", 3);
        gradeBook.add(2, "INTRODUCTION TO ALGEBRA AND ANALYSIS", 3);
        gradeBook.add(2, "INTRODUCTION TO DISCRETE MATH AND MATHEMATICAL LOGIC", 4);
        gradeBook.add(1, "DECLARATIVE PROGRAMMING", 5);
        gradeBook.add(1, "FUNDAMENTALS OF SPEECH CULTURE", 5);
        gradeBook.add(1, "FOREIGN LANGUAGE", 5);
        gradeBook.add(2, "FOREIGN LANGUAGE", 5);

        assertFalse(gradeBook.isIncreasedScholarship(1));
    }

}