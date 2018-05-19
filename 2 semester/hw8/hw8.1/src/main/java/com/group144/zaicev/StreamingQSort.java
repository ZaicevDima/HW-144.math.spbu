package com.group144.zaicev;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Class, which realises multi streaming quick sort
 */
public class StreamingQSort implements Sorter {

    @Override
    public void qsort(int[] array) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new Sort(0, array.length - 1, array));
    }

    /**
     * Class, which realises recursive quick sort
     */
    private class Sort extends RecursiveAction {
        int startIndex;
        int endIndex;
        int[] array;

        /**
         * Sort constructor
         * @param start new start index
         * @param end new end index
         * @param array new array
         */
        Sort(int start, int end, int[] array) {
            this.array = array;
            this.startIndex = start;
            this.endIndex = end;
        }

        /**
         * realises multi streaming quick sort
         */
        @Override
        public void compute() {
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

            Sort left = new Sort(this.startIndex, middle, array);
            Sort right = new Sort(middle + 1, endIndex, array);

            left.fork();
            right.fork();

            left.join();
            right.join();
        }
    }
}
