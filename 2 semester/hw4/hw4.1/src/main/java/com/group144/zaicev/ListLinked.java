package com.group144.zaicev;

public class ListLinked<Type> implements List<Type> {

    private class ListElement {
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

    @Override
    public boolean contains(Type element) {
        ListElement tempElement = head;
        for (int i = 0; i < size; i++) {
            if (tempElement.value == element) {
                return true;
            }
            tempElement = tempElement.next;
        }
        return false;
    }

    @Override
    public void add(Type value) throws ElementIsRepeat {
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

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void delete(Type value) throws NotFoundException {
        ListElement previous = null;
        ListElement current = head;

        while (current != null) {
            if (current.value == value) {
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
        throw new NotFoundException("Not found element");
    }

    @Override
    public void clear() {
        tail = null;
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Type valueOfIndex(int index) {
        if ((index >= size) || (index < 0)) {
            throw new IndexOutOfBoundsException("Wrong index");
        }

        ListElement current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }
}
