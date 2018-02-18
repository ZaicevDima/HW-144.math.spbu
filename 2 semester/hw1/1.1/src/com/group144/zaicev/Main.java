package com.group144.zaicev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> Stack = new Stack<Integer>();
        Scanner in = new Scanner(System.in);
        displayMenu();
        int operation = in.nextInt();

        while (operation != 0) {
            switch (operation) {
                case 1:
                    System.out.println("Enter value to add: ");
                    int value = in.nextInt();
                    Stack.push(value);
                    System.out.println("Enter operation: ");
                    operation = in.nextInt();
                    break;
                case 2:
                    if (Stack.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        Stack.pop();
                        System.out.println("Element was deleted");
                    }
                    System.out.println("Enter operation: ");
                    operation = in.nextInt();
                    break;
                case 3:
                    if (Stack.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println("Top value: " + Stack.top());
                    }
                    System.out.println("Enter operation: ");
                    operation = in.nextInt();
                    break;
                case 4:
                    displayMenu();
                    System.out.println("Enter operation: ");
                    operation = in.nextInt();
                    break;
                default:
                    System.out.println("Enter correct operation.");
                    System.out.println("Enter operation: ");
                    operation = in.nextInt();
            }
        }
    }

    public static void displayMenu() {
        System.out.println("menu :");
        System.out.println("0 - exit");
        System.out.println("1 - add");
        System.out.println("2 - pop");
        System.out.println("3 - top");
        System.out.println("4 - display the menu");
        System.out.println("Enter operation: ");
    }
}

