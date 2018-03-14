package com.group144.zaicev;

public class ArrayStack<Type> implements Stack<Type> {
    private int maxSize = 1000;
    private int size = 0;
    private Type[] array = (Type[]) new Object[maxSize];

    private void doubleArray() {
        Type[] temp = (Type[]) new Object[array.length * 2];
        System.arraycopy(array, 0, temp, 0, array.length);
        maxSize = maxSize * 2;
        array = temp;
    }

    @Override
    public void push(Type value) {
        if (size == maxSize) {
            doubleArray();
        }
        array[size] = value;
        size++;
    }

    @Override
    public Type pop() {
        if (isEmpty())
            return null;

        Type top = array[size - 1];
        array[size - 1] = null;
        size--;
        return top;
    }

    @Override
    public Type top() {
        return array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
