package com.group144.zaicev;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IncorrectTreeException {
        Scanner in;
        try {
            in = new Scanner(new FileInputStream("input"));
            ExpressionTree tree = new ExpressionTree(in);
            System.out.println("Your expression tree: ");
            tree.print(System.out);
            System.out.println("The result of your expression: ");
            System.out.println(tree.calculate());
        }
        catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
    }
}
