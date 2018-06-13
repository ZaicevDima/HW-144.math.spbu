package com.group144.zaicev;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionTreeTest {

    @Test
    public void calculateExpressionTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree("(* (- 1 1) 2)");
        int EXPECTED = 0;
        assertEquals(EXPECTED, tree.calculateTree());
    }

    @Test
    public void calculateExpressionWithTwoOperatorsTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree("(* (+ 12 2) (+ 2 3))");
        int EXPECTED = 70;
        assertEquals(EXPECTED, tree.calculateTree());
    }

    @Test
    public void calculateExpressionWithOneOperatorTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree("(* 5 2)");
        int EXPECTED = 10;
        assertEquals(EXPECTED, tree.calculateTree());
    }

    @Test
    public void printTreeTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree("(* 2 (+ 1 1))");
        String EXPECTED = "( * 2 ( + 1 1 ) )";

        assertEquals(EXPECTED, tree.toString());
    }

    @Test (expected = IncorrectTreeException.class)
    public void expressionWithWrongOperationTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree("(% (- 1 1) 2)");
        tree.calculateTree();
    }

    @Test (expected = IncorrectTreeException.class)
    public void expressionWithWrongValueTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree("(+ 1 a)");
        tree.calculateTree();
    }

    @Test (expected = ArithmeticException.class)
    public void expressionWithDivisionByZeroOperationTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree("(/ 5 0)");
        tree.calculateTree();
    }

    @Test (expected = IncorrectTreeException.class)
    public void expressionWithIncorrectOpeningBracketsTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree("(+ (* 2 3)");
        tree.calculateTree();
    }

    @Test (expected = IncorrectTreeException.class)
    public void expressionWithIncorrectClosingBracketsTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree("(+ (* 2 3))))");
        tree.calculateTree();
    }

    @Test (expected = IncorrectTreeException.class)
    public void calculateExpressionWithoutOperatorsTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree("1");
        tree.calculateTree();
    }
}