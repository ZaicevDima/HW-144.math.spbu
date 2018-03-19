package com.group144.zaicev;

/**
 * Class for work with List
 * @param <Type> - type your List
 */
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

    /**
     * Method that checks if your value is in a list
     * @param element - element, which you want check
     * @return true, if your value is contains in hash table, else false
     */
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

    /**
     * Method, which add value in your hash table
     * @param value - value, which you want add
     */
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

    /** Method, which return size your List */
    public int getSize() {
        return size;
    }

    /**
     * Method, which remove value from your hash table
     * @param value - value, which you want remove
     * @throws ValueNotFound, if your value is not found
     */
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

    /**
     * method, which clear List
     */
    public void clear() {
        tail = null;
        head = null;
        size = 0;
    }

    /**
     * Method, which return value by index
     * @param index - your index
     * @return value by index
     * @throws IndexBeyondBorders if the index is outside the borders
     */
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

    /**
     * Method, which return list element with this value
     */
    public ListElement findElement(Type value) {
        ListElement temp = head;
        while ((temp != null)) {
            if (temp.value.equals(value)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * method, which checks if the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Method, which print list
     * @throws ListIsEmptyException if list, which need print is empty
     */
    public void print() throws ListIsEmptyException {
        if (isEmpty()) {
            throw new ListIsEmptyException("List is empty");
        }
        ListElement temp = head;
        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
}