package ru.nsu.yadryshnikova;

import java.util.Scanner;

public class Calculator extends Arithmetic {

    public static double main(String args) {
        Scanner scanner = new Scanner(args);
        return nextArg(scanner);
    }

    public static double calculate(Scanner scan) {
        return nextArg(scan);
    }

    private  static double nextArg(Scanner scan) {
        String arg = scan.next();
        switch (arg) {
            case "+":
                return Arithmetic.add(nextArg(scan), nextArg(scan));
            case "-":
                return Arithmetic.sub(nextArg(scan), nextArg(scan));
            case "*":
                return Arithmetic.mult(nextArg(scan), nextArg(scan));
            case "/":
                return Arithmetic.div(nextArg(scan), nextArg(scan));
            case "log":
                return Arithmetic.log(nextArg(scan));
            case "pow":
                return Arithmetic.sqrt(nextArg(scan));
            case "sin":
                return Arithmetic.sin(nextArg(scan));
            case "cos":
                return Arithmetic.cos(nextArg(scan));
            default:
                return Double.parseDouble(arg);
        }
    }
}

