package ru.nsu.yadryshnikova;

import ru.nsu.yadryshnikova.operations.Operation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Calculator {

    public static double calculate(String input) throws ParseException {
        Scanner scanner = new Scanner(input);
        return calculate(scanner);
    }

    /**
     * Calculate expression result in prefix notation.
     * @param scanner provides a string of expressions
     * @return expression result
     * @throws ParseException if error has been reached while parsing.
     */
    public static double calculate(Scanner scanner) throws ParseException {
        try {
            return nextExpr(scanner);
        } catch (RuntimeException exception) {
            if (Objects.equals(exception.getMessage(), "You have not entered enough arguments")) {
                throw new ParseException("Empty input provided", 0);
            } else {
                throw new ParseException(exception.getMessage(), 1);
            }
        }
    }

    private static double nextExpr(Scanner scanner) throws ParseException {
        String arg;
        if (scanner.hasNext()) {
            arg = scanner.next();
        } else {
            throw new RuntimeException("You have not entered enough arguments");
        }

        Operation operation = Arithmetic.operation(arg);

        List<Double> args = new ArrayList<>();
        for (int i = 0; i < operation.argsCount(); i++) {
            try {
                args.add(nextExpr(scanner));
            } catch (RuntimeException exception) {
                throw new ParseException(exception.getMessage() + " in " + operation, operation.argsCount());
            }

        }

        return operation.apply(args);
    }

}

