package com.group144.zaicev;

import java.util.Comparator;

/**
 * Class, which realizes bubble sort
 *
 * @param <Type> Type your array
 */
public class BubbleSort<Type> {

    /**
     * realizes bubble sort
     *
     * @param array      array, which you want to sort
     * @param comparator for comparing two elements from the your array
     */
    public void bubbleSort(Type[] array, Comparator<Type> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (isFirstElementGreatest(array[j], array[j + 1], comparator)) {
                    Type temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Checks the first element is greater than the second element
     *
     * @param firstElement  first element value
     * @param secondElement second element value
     * @param comparator    for comparing two element
     * @return true, if first element > or = than second
     */
    private boolean isFirstElementGreatest(Type firstElement, Type secondElement, Comparator<Type> comparator) {
        return comparator.compare(firstElement, secondElement) > 0;
    }
}