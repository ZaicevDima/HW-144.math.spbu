package com.group144.zaicev;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class for working with the operator from the expression tree
 */
class Operator implements Node {
    private Node rightNode;
    private Node leftNode;
    private char operation;

    /**
     * Method for working with an expression tree node
     * saves the operation and creates left and right nodes from the expression tree
     * @param in input stream
     * @throws IncorrectTreeException if the value from leaves the expression tree is incorrect
     */
    Operator(Scanner in) throws IncorrectTreeException {
        String partWithOperation = in.next();
        operation = partWithOperation.charAt(partWithOperation.length() - 1);
        if (partWithOperation.charAt(0) != '(') {
            throw new IncorrectTreeException("the correct number was expected");
        }

        if (in.hasNextInt()) {
            leftNode = new Operand(in);
        } else {
            leftNode = new Operator(in);
        }

        if (in.hasNext(Pattern.compile("[-]?[0-9]+[)]+"))) {
            rightNode = new Operand(in);
        } else {
            rightNode = new Operator(in);
        }
    }

    @Override
    public int calculate() throws IncorrectTreeException {
        switch (operation) {
            case ('+'):
                return leftNode.calculate() + rightNode.calculate();
            case ('-'):
                return leftNode.calculate() - rightNode.calculate();
            case ('*'):
                return leftNode.calculate() * rightNode.calculate();
            case ('/'):
                return leftNode.calculate() / rightNode.calculate();
        }
        throw new IncorrectTreeException("operation not found");
    }

    @Override
    public void print(PrintStream printStream) {
        printStream.print("( " + operation + " ");
        leftNode.print(printStream);
        printStream.print(" ");
        rightNode.print(printStream);
        printStream.print(" )");
    }
}
