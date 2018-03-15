package com.group144.zaicev;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter length of array:");
        int length = in.nextInt();

        System.out.println("Enter array: ");
        int[][] array = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                array[i][j] = in.nextInt();
            }
        }

        System.out.println("Enter 1 for print in console or 2 for print in file: ");
        int operation = in.nextInt();
        if (operation == 1) {
            Print output = new PrintConsole();
            output.printSpiral(array);
        } else {
            Print output = new PrintFile();
            output.printSpiral(array);
        }
    }
}