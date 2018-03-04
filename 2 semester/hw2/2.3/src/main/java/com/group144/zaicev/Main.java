package com.group144.zaicev;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter 1, if you want to using Array Stack or 2, if you want to using Dynamic Stack");
        Scanner in = new Scanner(System.in);

        int voice = in.nextInt();
        System.out.println("Enter your expression");
        String expression = in.next();

        if (voice == 1) {
            Stack stack = new ArrayStack();
            Calculator calculator = new Calculator(stack, stack);
            int result = calculator.consider(expression);
            System.out.println(result);
        } else if (voice == 2){
            Stack stack = new DynamicStack();
            Calculator calculator = new Calculator(stack, stack);
            int result = calculator.consider(expression);
            System.out.println(result);
        } else {
            System.out.println("Wrong operation");
        }
    }
}
