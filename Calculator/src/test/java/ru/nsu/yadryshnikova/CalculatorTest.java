package ru.nsu.yadryshnikova;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculate_value() throws ParseException {
        assertEquals(120, Calculator.calculate("120"));
    }

    @Test
    void calculate_add() throws ParseException {
        assertEquals(120, Calculator.calculate("+ -120 + 120 120"));
    }

    @Test
    void calculate_sub() throws ParseException {
        assertEquals(120, Calculator.calculate("- - - - 130 5 3 2 0"));
    }

    @Test
    void calculate_mul() throws ParseException {
        assertEquals(-120, Calculator.calculate("* 60 * 2 -1"));
    }

    @Test
    void calculate_div() throws ParseException {
        assertEquals(120, Calculator.calculate("/ 1200 / 100 10"));
    }

    @Test
    void calculate_log() throws ParseException {
        assertEquals(1.95, Calculator.calculate("log log 1200"), 0.01);
    }

    @Test
    void calculate_pow() throws ParseException {
        assertEquals(1024.0, Calculator.calculate("pow 2 10"));
    }

    @Test
    void calculate_sqrt() throws ParseException {
        assertEquals(120, Calculator.calculate("sqrt 14400"));
    }

    @Test
    void calculate_sqrtMul() throws ParseException {
        assertEquals(120, Calculator.calculate("sqrt * 120 120"));
    }

    @Test
    void calculate_sin() throws ParseException {
        assertEquals(0.58, Calculator.calculate("sin 120"), 0.01);
    }

    @Test
    void calculate_cos() throws ParseException {
        assertEquals(0.81, Calculator.calculate("cos 120"), 0.01);
    }

    @Test
    void calculate_expression() throws ParseException {
        assertEquals(5873.39, Calculator.calculate("* sqrt 31136 + 25 - 14 / 10 / 56 pow 2 5"), 0.01);
    }


    @Test
    void calculate_exceptionNotEnoughArgs() {
        assertThrows(ParseException.class, () -> Calculator.calculate("* 1 * 4"));
    }

    @Test
    void calculate_exceptionEmptyInput() {
        assertThrows(ParseException.class, () -> Calculator.calculate(""));
    }

    @Test
    void calculate_exceptionUnknownOperation() {
        assertThrows(ParseException.class, () -> Calculator.calculate("bla 10"));
    }
}