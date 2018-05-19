package com.group144.zaicev;

import java.util.Random;

import static java.lang.Math.abs;

/**
 * Class for checking the working time of two sorts
 */
public class Main {

    public static void main(String[] args) {
        comparison();
    }

    /**
     * compares the time of work of sorts
     */
    private static void comparison() {
        Sorter usualQSort = new QSort();
        Sorter streamingQSort = new StreamingQSort();
        int AMOUNT_ARRAYS = 10;

        int sumTimeUsualQSort = 0;
        int sumTimeStreamingQSort = 0;

        for (int i = 0; i < AMOUNT_ARRAYS; i++) {
            System.out.println("test number: " + (i + 1));
            int ARRAY_MAX_SIZE = 1000;
            int[] firstArray = createArray(ARRAY_MAX_SIZE);
            int[] secondArray = firstArray.clone();

            long timeUsualQSort = getTime(firstArray, usualQSort);
            System.out.println("time for which the array was sorted with usual quick sort: " + timeUsualQSort);
            sumTimeUsualQSort += timeUsualQSort;

            long timeStreamingQSort = getTime(secondArray, streamingQSort);
            System.out.println("time for which the array was sorted with streaming quick sort: " + timeStreamingQSort);
            sumTimeStreamingQSort += timeStreamingQSort;

            System.out.println();
        }

        System.out.println("\n" + "Average time for sorting arrays using usual quick sorting: " + (double) sumTimeUsualQSort / AMOUNT_ARRAYS);
        System.out.println("Average time for sorting arrays using streaming quick qsort: " + (double) sumTimeStreamingQSort / AMOUNT_ARRAYS);
    }

    /**
     * Gets the time of work of sort
     * @param array array for sorting
     * @param sorter sort, which you choiced
     * @return time of work this sorting
     */
    private static long getTime(int[] array, Sorter sorter) {
        long startTime = System.nanoTime();
        sorter.qsort(array);
        return System.nanoTime() - startTime;
    }

    /**
     * generates array
     * @param maxLength max length of the array
     * @return new array
     */
    private static int[] createArray(int maxLength) {
        Random random = new Random();
        int length = abs(random.nextInt()) % maxLength;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}