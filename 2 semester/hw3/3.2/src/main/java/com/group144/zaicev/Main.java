package com.group144.zaicev;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ValueNotFound, FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1, if you want use polinomialHahFunction, else 2, if you want use lengthHashFunction");
        int answer = in.nextInt();
        HashTable hashTable;
        while ((answer != 1) && (answer!= 2)) {
            System.out.println("enter correct answer");
            answer = in.nextInt();
        }

        if (answer == 1) {
            hashTable = new HashTable(new PolinomialHashFunction());
            System.out.println("Your choice is polinomialHashFunction");
        } else {
            hashTable = new HashTable(new LengthHashFunction());
            System.out.println("Your choice is lengthHashFunction");
        }

        printMenu();
        String choice = in.next();
        while (!choice.equals("exit")) {
            switch (choice) {
                case "add":
                    hashTable.add(in.next());
                    System.out.println("added");
                    break;
                case "remove":
                    hashTable.delete(in.next());
                    System.out.println("deleted");
                    break;
                case "information":
                    hashTable.getInformation();
                    break;
                case  "load":
                    scanfOfFile(hashTable);
                    System.out.println("loaded");
                    break;
                case  "find":
                    hashTable.findValue(in.next());
                    break;
            }
            choice = in.next();
        }
    }

    private static void scanfOfFile(HashTable hashTable) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner in = new Scanner(file);
        while (in.hasNext()) {
            hashTable.add(in.next());
        }
    }

    private static void printMenu() {
        System.out.println("exit - finish your words");
        System.out.println("add - add to hashtable");
        System.out.println("remove - remove from hashtable");
        System.out.println("information - get information about hashtable");
        System.out.println("find - find your value");
        System.out.println("load - load from file");
        System.out.println("menu - show menu again");
    }
}
