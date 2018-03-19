package com.group144.zaicev;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** class main */
public class Main {
    public static void main(String[] args) throws ValueNotFound, FileNotFoundException, ListIsEmptyException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1, if you want use polinomialHahFunction, else 2, if you want use lengthHashFunction");
        int answer = in.nextInt();
        HashTable hashTable;
        while ((answer != 1) && (answer!= 2)) {
            System.out.println("enter correct answer");
            answer = in.nextInt();
        }

        if (answer == 1) {
            hashTable = new HashTable(new PolynomialHashFunction());
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
                    System.out.println("enter value, which you want add");
                    hashTable.add(in.next());
                    System.out.println("added");
                    break;
                case "remove":
                    System.out.println("enter value, which you want remove");
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
                case  "check":
                    System.out.println("enter value, which you want check");
                    if (hashTable.isContains(in.next())) {
                        System.out.println("your value is in hashtable");
                    } else {
                        System.out.println("your value isn't in hashtable");
                    }
                    break;
                default:
                    System.out.println("enter correct choice");
            }
            choice = in.next();
        }
    }

    /**
     * Method for loading data from a file
     * @param hashTable - hash table for data recording
     * @throws FileNotFoundException if file is not found
     */
    private static void scanfOfFile(HashTable hashTable) throws FileNotFoundException {
        File file = new File("/home/li-man/Git/HW-144.math.spbu/2 semester/hw3/3.2/src/main/java/com/group144/zaicev/input.txt");
        Scanner in = new Scanner(file);
        while (in.hasNext()) {
            hashTable.add(in.next());
        }
    }

    /** Method, which print menu */
    private static void printMenu() {
        System.out.println("exit - finish your words");
        System.out.println("add - add to hashtable");
        System.out.println("remove - remove from hashtable");
        System.out.println("information - get information about hashtable");
        System.out.println("check - check your value");
        System.out.println("load - load from file");
        System.out.println("menu - show menu again");
    }
}
