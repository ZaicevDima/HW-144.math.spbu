package com.group144.zaicev;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Class for working with the expression tree
 */
public class ExpressionTree implements Node {
    private Node root;

    /**
     * Method for reading the tree from the stream
     * @param in stream
     * @throws IncorrectTreeException if tree is incorrect
     */
    ExpressionTree(Scanner in) throws IncorrectTreeException {
        if (in.hasNextInt()) {
            root = new Operand(in);
        } else {
            root = new Operator(in);
        }
    }

    @Override
    public int calculate() throws IncorrectTreeException {
       return  root.calculate();
    }

    @Override
    public void print(PrintStream printStream) {
        root.print(printStream);
    }
}
