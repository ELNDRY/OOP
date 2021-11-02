package ru.nsu.yadryshnikova;

import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticTest {

    @Test
    void add() {
        assertEquals(120, Calculator.main("+ 100 20"));
    }

    @Test
    void sub() {
        assertEquals(80, Calculator.main("- 100 20"));
    }

    @Test
    void mult() {
        assertEquals(200, Calculator.main("* 100 2"));
    }

    @Test
    void div() {
        assertEquals(50, Calculator.main("/ 100 2"));
    }

    @Test
    void log() {
        assertEquals(4.61, (double)Math.round(Calculator.main("log 100")*100)/100);
    }

    @Test
    void pow() {
    }

    @Test
    void sqrt() {
    }

    @Test
    void sin() {
    }

    @Test
    void cos() {
    }
}