package com.group144.zaicev;
import java.util.Scanner;

public class List<Type> {

    private class ListElement {
        Type value;
        ListElement next;
        ListElement(Type value, ListElement next) {
            this.value = value;
            this.next = next;
        }
    }

    private ListElement head = null;
    private int size = 0;

    public void add(Type value) {
        if (size == 0) {
            this.head = new ListElement(value, null);
            this.size++;
            return;
        }

        ListElement newElement = new ListElement(value, null);
        ListElement tempElement = head;
        while (tempElement.next != null) {
            tempElement = tempElement.next;
        }

        tempElement.next = newElement;
        size++;
    }

    public void printList() {
        if (size == 0) {
            return;
        }

        ListElement current = head;
        while (current.next != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println(current.value);
    }

    public int size() {
        return size;
    }

    public void pop() {
        if (size > 1) {
            ListElement tempElement = head;
            while (tempElement.next.next != null) {
                tempElement = tempElement.next;
            }
            tempElement.next = null;
        } else if (size == 0) {
            return;
        } else {
            head = null;
        }
        size--;
    }

    public void clear() {
        while (size != 0) {
            pop();
        }
    }

    public Type valueOfIndex(int index) {
        ListElement current = head;
        int i = 0;
        while (i != index) {
            i++;
            current = current.next;
        }
        return current.value;
    }
}

