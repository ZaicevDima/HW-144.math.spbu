package com.group144.zaicev;

import java.io.PrintStream;

/**
 * Interface for working with nodes from the expression tree
 */
public interface Node {

    /**
     * Method, wich calculate value from your tree
     * @return computation value
     * @throws IncorrectTreeException if tree is incorrect
     * for example a tree with an incorrect operation or a symbol instead of a number
     */
    int calculate() throws IncorrectTreeException;

    /**
     * Method, wich print your tree
     * @param printStream print stream where the tree will be output
     */
    void print(PrintStream printStream);
}
