package com.group144.zaicev;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTest {

    @Test
    public void sortIntegerArrayTest() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5};
        Integer[] sorted = {1, 2, 3, 4, 5};

        BubbleSort<Integer> sort = new BubbleSort<>();
        sort.bubbleSort(array, Integer::compareTo);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortIntegerSame() {
        Integer[] array = {1, 1, 1, 1, 1};
        Integer[] sorted = {1, 1, 1, 1, 1};

        BubbleSort<Integer> sort = new BubbleSort<>();
        sort.bubbleSort(array, Integer::compareTo);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortIntegerUnsortedTest() {
        Integer[] array = {1, 3, 5, 4, 2};
        Integer[] sorted = {1, 2, 3, 4, 5};

        BubbleSort<Integer> sort = new BubbleSort<>();
        sort.bubbleSort(array, Integer::compareTo);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortCharacterUnsortedTest() {
        Character[] array = {'1', '3', '5', '4', '2'};
        Character[] sorted = {'1', '2', '3', '4', '5'};

        BubbleSort<Character> sort = new BubbleSort<>();
        sort.bubbleSort(array, Character::compareTo);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortStringUnsortedTest() {
        String[] array = {"1", "3", "5", "4", "2"};
        String[] sorted = {"1", "2", "3", "4", "5"};

        BubbleSort<String> sort = new BubbleSort<>();
        sort.bubbleSort(array, String::compareTo);
        assertArrayEquals(sorted, array);
    }
}