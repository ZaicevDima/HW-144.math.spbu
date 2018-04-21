package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ExpressionTreeTest {

    @Test
    public void calculateExpressionTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree(new Scanner("(* (+ 1 1) 2)"));
        int EXPECTED = 4;
        Assert.assertEquals(EXPECTED, tree.calculate());
    }

    @Test
    public void printTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree(new Scanner("(* (+ 1 1) 2)"));
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        tree.print(new PrintStream(arrayOutputStream));
        String EXPECTED = "( * ( + 1 1 ) 2 )";
        Assert.assertEquals(EXPECTED, arrayOutputStream.toString());
    }

    @Test
    public void expressionWithOneValueTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree(new Scanner("5"));
        int EXPECTED = 5;
        Assert.assertEquals(EXPECTED, tree.calculate());
    }

    @Test
    public void expressionWithOneOperationTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree(new Scanner("(- 5 2)"));
        int EXPECTED = 3;
        Assert.assertEquals(EXPECTED, tree.calculate());
    }

    @Test (expected = IncorrectTreeException.class)
    public void expressionWithWrongOperationTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree(new Scanner("(% (- 1 1) 2)"));
        tree.calculate();
    }

    @Test (expected = IncorrectTreeException.class)
    public void expressionWithWrongValueTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree(new Scanner("(+ (/ 1 1) a)"));
        tree.calculate();
    }

    @Test (expected = ArithmeticException.class)
    public void expressionWithDivisionOperationTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree(new Scanner("(/ 5 0)"));
        tree.calculate();
    }

    @Test (expected = IncorrectTreeException.class)
    public void expressionWithNotFoundOperationTest() throws IncorrectTreeException {
        ExpressionTree tree = new ExpressionTree(new Scanner("(% 5 2)"));
        tree.calculate();
    }
}