package com.group144.zaicev;

import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * Class for working with the operand from the expression tree
 */
public class Operand implements Node {
    private int value;

    /**
     * Method for work with operand value
     * @param in input stream
     */
    Operand(Scanner in) {
        String operand = in.next();
        if (operand.charAt(operand.length() - 1) == ')') {
            value = parseInt(operand.substring(0, operand.indexOf(')')));
        } else {
            value = parseInt(operand);
        }
    }

    @Override
    public int calculate() {
        return value;
    }

    @Override
    public void print(PrintStream printStream) {
        printStream.print(value);
    }
}
