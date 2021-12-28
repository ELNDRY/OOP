package ru.nsu.yadryshnikova;

import ru.nsu.yadryshnikova.operations.*;

public class Arithmetic {

    /**
     * @param arg specifies the type of operation
     */

    public static Operation operation(String arg) {
        return switch (arg) {
            case "+" -> new Add();
            case "-" -> new Sub();
            case "*" -> new Mult();
            case "/" -> new Div();
            case "log" -> new Log();
            case "pow" -> new Pow();
            case "sin" -> new Sin();
            case "cos" -> new Cos();
            case "sqrt" -> new Sqrt();
            default -> new Val(Double.parseDouble(arg));
        } ;
    }
}
