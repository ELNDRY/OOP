package ru.nsu.yadryshnikova;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

class GradeBookTest {

    GradeBook gradeBook;

    @BeforeEach
    void gradeBook_constructor() {
        Map<GradeBook.Subject, GradeBook.Grade[]> marks = new HashMap<>();

        marks.put(GradeBook.Subject.INTRODUCTION_TO_ALGEBRA_AND_ANALYSIS,
                new GradeBook.Grade[]{GradeBook.Grade.SATISFACTORY, GradeBook.Grade.SATISFACTORY}
        );
        marks.put(GradeBook.Subject.INTRODUCTION_TO_DISCRETE_MATH_ANDMATHEMATICAL_LOGIC,
                new GradeBook.Grade[]{GradeBook.Grade.GOOD}
        );
        marks.put(GradeBook.Subject.DECLARATIVE_PROGRAMMING,
                new GradeBook.Grade[]{GradeBook.Grade.GOOD}
        );
        marks.put(GradeBook.Subject.IMPERATIVE_PROGRAMMING,
                new GradeBook.Grade[]{GradeBook.Grade.SATISFACTORY}
        );
        marks.put(GradeBook.Subject.FUNDAMENTALS_OF_SPEECH_CULTURE,
                new GradeBook.Grade[]{GradeBook.Grade.EXСELLENT}
        );

        marks.put(GradeBook.Subject.FOREIGN_LANGUAGE,
                new GradeBook.Grade[]{GradeBook.Grade.EXСELLENT}
        );

        marks.put(GradeBook.Subject.DIGITAL_PLATFORMS,
                new GradeBook.Grade[]{GradeBook.Grade.GOOD}
        );

        marks.put(GradeBook.Subject.MEASURING_WORKSHOP,
                new GradeBook.Grade[]{GradeBook.Grade.EXСELLENT}
        );

        marks.put(GradeBook.Subject.HISTORY,
                new GradeBook.Grade[]{GradeBook.Grade.EXСELLENT}
        );

        gradeBook = new GradeBook(marks, GradeBook.Grade.EXСELLENT, 200613, "Yadryshnikova E.E.", "FIT", "Computer science and engineering");
    }


    @Test
    void getAverageScore() {
        assertEquals(4.0, gradeBook.getAverageScore());
    }

    @Test
    void isRedDiploma() {
        assertFalse(gradeBook.isRedDiploma());
    }

    @Test
    void isIncreasedScholarship() {
        assertFalse(gradeBook.isIncreasedScholarship());
    }
}