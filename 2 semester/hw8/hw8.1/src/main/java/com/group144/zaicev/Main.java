package com.group144.zaicev;

import java.util.Random;

import static java.lang.Math.abs;

/**
 * Class for checking the working time of two sorts
 */
public class Main {

    private static int AMOUNT_ARRAYS = 10;
    private static int MAX_SIZE = 100000000;

    public static void main(String[] args) {
        comparison();
    }

    /**
     * compares the time of work of sorts
     */
    private static void comparison() {
        Sorter usualQSort = new QSort();
        Sorter streamingQSort = new StreamingQSort();

        double sumTimeUsualQSort = 0;
        double sumTimeStreamingQSort = 0;

        int[] firstArray = new int[MAX_SIZE];
        int[] secondArray = firstArray.clone();


        for (int i = 0; i < AMOUNT_ARRAYS; i++) {

            sumTimeUsualQSort += getTime(firstArray, usualQSort);
            sumTimeStreamingQSort += getTime(secondArray, streamingQSort);

            initialize(firstArray);
            secondArray = firstArray.clone();
        }

        System.out.println("\n" + "Average time for sorting arrays using usual quick sorting: " + sumTimeUsualQSort / AMOUNT_ARRAYS);
        System.out.println("Average time for sorting arrays using streaming quick qsort: " + sumTimeStreamingQSort / AMOUNT_ARRAYS);
    }

    /**
     * Gets the time of work of sort
     *
     * @param array  array for sorting
     * @param sorter sort, which you choiced
     * @return time of work this sorting
     */
    private static long getTime(int[] array, Sorter sorter) {
        long startTime = System.currentTimeMillis();
        sorter.qsort(array);
        return System.currentTimeMillis() - startTime;
    }

    /**
     * initializes the array
     *
     * @param array array, to be changed
     */
    private static void initialize(int[] array) {
        Random random = new Random();
        for (int i = 0; i < MAX_SIZE; i++) {
            array[i] = random.nextInt();
        }
    }
}