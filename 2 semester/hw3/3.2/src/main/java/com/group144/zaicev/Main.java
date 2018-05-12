package com.group144.zaicev;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IncorrectTreeException {
        Scanner in;
        try {
            in = new Scanner(new FileInputStream("input"));
            String infixForm = "";
            while (in.hasNext()) {
                infixForm = infixForm.concat(in.next());
                if (in.hasNext()) {
                    infixForm = infixForm.concat(" ");
                }
            }
            ExpressionTree tree = new ExpressionTree(infixForm);
            System.out.println("Your expression tree: ");
            tree.printTree();
            System.out.println();
            System.out.println("The result of your expression: ");
            int result = tree.calculateTree();
            System.out.print(result);
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
    }
}
