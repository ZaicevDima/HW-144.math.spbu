package com.group144.zaicev;

import java.util.Random;

/**
 * Class for checking the working time of two sorts
 */
public class Main {

    private static int MAX_SIZE = 100000;

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
        int[] secondArray;


        int AMOUNT_ARRAYS = 100;
        for (int i = 0; i < AMOUNT_ARRAYS; i++) {
            double timeUsualQsort;
            double timeStreamingQsort;

            initialize(firstArray);
            secondArray = firstArray.clone();

            timeUsualQsort = getTime(firstArray, usualQSort);
            timeStreamingQsort = getTime(secondArray, streamingQSort);
            System.out.println("usual qsort: " + timeUsualQsort);
            System.out.println("streaming qsort: " + timeStreamingQsort + "\n");


            sumTimeUsualQSort += timeUsualQsort;
            sumTimeStreamingQSort += timeStreamingQsort;
        }

        System.out.println("\n" + "Average time for sorting arrays using usual quick sorting: " + sumTimeUsualQSort / AMOUNT_ARRAYS);
        System.out.println("Average time for sorting arrays using streaming quick qsort: " + sumTimeStreamingQSort / AMOUNT_ARRAYS);
    }

    /**
     * Gets the time of work of sort
     *
     * @param array  array for sorting
     * @param sorter sort, which you choices
     * @return time of work this sorting
     */
    private static double getTime(int[] array, Sorter sorter) {
        long startTime = System.currentTimeMillis();
        sorter.qsort(array);
        long finishTime = System.currentTimeMillis();
        return (double) (finishTime - startTime);
    }

    /**
     * initializes the array
     *
     * @param array array, to be changed
     */
    private static void initialize(int[] array) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        for (int i = 0; i < MAX_SIZE; i++) {
            array[i] = random.nextInt();
        }
    }
}