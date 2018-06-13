package com.group144.zaicev;

/**
 * Class for working with nodes from tree
 */
abstract class Node {
    Node leftNode = null;
    Node rightNode = null;
    String valueOfNode;

    /**
     * Prints node
     */
    abstract void print();

    /**
     * Calculates node of expression tree
     *
     * @return result of calculating
     * @throws IncorrectTreeException if your node is incorrect (e.g. has incorrect symbol)
     */
    abstract int calculate() throws IncorrectTreeException;

    /**
     * Converts node to a string
     *
     * @return converting node
     */
    public abstract String toString();
}