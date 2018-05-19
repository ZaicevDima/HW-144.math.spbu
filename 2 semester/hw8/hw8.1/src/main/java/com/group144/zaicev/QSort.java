package com.group144.zaicev;

/**
 * Class, which realises usual quick sort
 */
public class QSort implements Sorter {

    @Override
    public void qsort(int[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        sort(startIndex, endIndex, array);
    }

    /**
     * realises usual quick sort
     * @param startIndex start index
     * @param endIndex end index
     * @param array array to be sorted
     */
    private void sort(int startIndex, int endIndex, int[] array) {
        if (startIndex >= endIndex) {
            return;
        }

        int start = startIndex;
        int end = endIndex;
        int middle = start - (start - end) / 2;

        while (start < end) {
            while ((start < middle) && (array[start] <= array[middle])) {
                start++;
            }

            while ((end > middle) && (array[middle] <= array[end])) {
                end--;
            }

            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                if (start == middle) {
                    middle = end;
                } else if (end == middle) {
                    middle = start;
                }
            }
        }

        sort(startIndex, middle, array);
        sort(middle + 1, endIndex, array);
    }
}
