package com.group144.zaicev;

public class DynamicStack<Type> implements Stack<Type> {
    private class StackElement {
        Type value;
        StackElement next;
        StackElement(Type value, StackElement next) {
            this.value = value;
            this.next = next;
        }
    }

    private StackElement head = null;

    @Override
    public void push(Type value) {
        head = new StackElement(value, head);
    }

    @Override
    public Type pop() {
        if (isEmpty())
            return null;

        Type value = head.value;
        head = head.next;
        return value;
    }

    @Override
    public Type top() {
        if (isEmpty())
            return null;
        return head.value;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
