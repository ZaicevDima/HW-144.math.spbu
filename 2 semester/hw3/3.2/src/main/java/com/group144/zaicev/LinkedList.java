package com.group144.zaicev;

import static sun.misc.Version.println;

class LinkedList<Type extends Comparable> {

    /** Class, which creates list element */
    class ListElement {
        Type value;
        ListElement next;
        ListElement(Type value, ListElement next) {
            this.value = value;
            this.next = next;
        }
    }

    private ListElement head = null;
    private ListElement tail = null;
    private int size = 0;

    public boolean contains(Type element) {
        ListElement current = head;
        for (int i = 0; i < size; i++) {
            if (current.value == element) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void add(Type value) {
        if (size == 0) {
            this.head = new ListElement(value, null);
            this.tail = head;
            this.size++;
            return;
        }
        ListElement newElement = new ListElement(value, null);
        tail.next = newElement;
        tail = newElement;
        size++;
    }

    public int getSize() {
        return size;
    }

    public void delete(Type value) throws ValueNotFound {
        ListElement previous = null;
        ListElement current = head;

        while (current != null) {
            if (current.value.equals(value)) {
                if (previous != null) {
                    previous.next = current.next;
                    if (current.next == null) {
                        tail = previous;
                    }
                } else {
                    head = head.next;
                    if (head == null) {
                        tail = null;
                    }
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
        throw new ValueNotFound("Not found element");
    }

    public void clear() {
        tail = null;
        head = null;
        size = 0;
    }

    public Type valueOfIndex(int index) throws IndexBeyondBorders {
        if ((index >= size) || (index < 0)) {
            throw new IndexBeyondBorders("Wrong index");
        }
        ListElement current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public ListElement foundElement(Type value) {
        ListElement temp = head;
        while ((temp != null)) {
            if (temp.value.equals(value)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        ListElement temp = head;
        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
}