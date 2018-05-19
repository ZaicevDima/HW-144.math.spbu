package com.group144.zaicev;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class StreamingQSortTest {

    @Test
    public void sortSortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] sorted = {1, 2, 3, 4, 5};
        Sorter sorter = new StreamingQSort();
        sorter.qsort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortSame() {
        int[] array = {1, 1, 1, 1, 1};
        int[] sorted = {1, 1, 1, 1, 1};
        Sorter sorter = new StreamingQSort();
        sorter.qsort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortUnsorted() {
        int[] array = {1, 3, 5, 4, 2};
        int[] sorted = {1, 2, 3, 4, 5};
        Sorter sorter = new StreamingQSort();
        sorter.qsort(array);
        assertArrayEquals(sorted, array);
    }
}