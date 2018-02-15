package com.group144.zaicev;

import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> List = new List<Integer>();
        Scanner in = new Scanner(System.in);
        Menu();

        out.println("Enter operation: ");
        int operation = in.nextInt();

        while (operation != 0) {
            switch (operation) {
                case 1:
                    out.println("Enter value to add: ");
                    int value = in.nextInt();
                    List.add(value);
                    out.println("Enter operation: ");
                    operation = in.nextInt();
                    break;
                case 2:
                    if (List.size() != 0)
                        out.println("last value is deleted.");
                    else
                        out.println("List is empty.");
                    List.pop();
                    out.println("Enter operation: ");
                    operation = in.nextInt();
                    break;
                case 3:
                    if (List.size() == 0) {
                        out.println("List is empty.");
                    }
                    else {
                        out.println("the elements from your list: ");
                        List.printList();
                    }
                    out.println("Enter operation: ");
                    operation = in.nextInt();
                    break;
                case 4:
                    List.clear();
                    out.println("Your list is cleared.");
                    out.println("Enter operation: ");
                    operation = in.nextInt();
                    break;
                case 5:
                    if (List.size() != 0) {
                        out.println("Enter index: ");
                        int index = in.nextInt();
                        while (index >= List.size()) {
                            out.println("error, wrong index. Enter correct index.1");
                            index = in.nextInt();
                        }
                        out.println("index (" + index + ") value: " + List.valueOfIndex(index));
                    }
                    else {
                        out.println("List is empty, you can't this function.");
                    }

                    out.println("Enter operation: ");
                    operation = in.nextInt();
                    break;
                case 6:
                    out.println("Size your list: " + List.size());
                    out.println("Enter operation: ");
                    operation = in.nextInt();
                    break;
                case 7:
                    Menu();
                    out.println("Enter operation: ");
                    operation = in.nextInt();
                    break;
                default:
                    out.println("Enter correct operation: ");
                    operation = in.nextInt();
                    break;
            }
        }
    }

    public static void Menu() {
        out.println("menu :");
        out.println("0 - exit");
        out.println("1 - add");
        out.println("2 - pop");
        out.println("3 - print");
        out.println("4 - clear");
        out.println("5 - value of index");
        out.println("6 - size");
        out.println("7 - menu");
    }
}
