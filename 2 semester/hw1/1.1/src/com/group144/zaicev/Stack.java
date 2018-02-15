package com.group144.zaicev;

public class Stack<Type> {
    private class StackElement {
        public Type value;
        public StackElement next;
        public StackElement(Type value, StackElement next) {
            this.value = value;
            this.next = next;
        }
    }

    private StackElement head = null;

    public void push(Type value) {
        StackElement newElement = new StackElement(value, head);
        head = newElement;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Type pop() {
        if (isEmpty())
            return null;

        Type value = head.value;
        head = head.next;
        return value;
    }

    public Type top() {
        if (isEmpty())
            return null;
        return head.value;
    }
}
