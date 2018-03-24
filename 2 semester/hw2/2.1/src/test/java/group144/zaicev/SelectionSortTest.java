package group144.zaicev;

import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionSortTest {

    @Test
    public void sortArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] sorted = {1, 2, 3, 4, 5};
        Sorter sorter = new SelectionSort();
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortSame() {
        int[] array = {1, 1, 1, 1, 1};
        int[] sorted = {1, 1, 1, 1, 1};
        Sorter sorter = new SelectionSort();
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortUnsorted() {
        int[] array = {1, 3, 5, 4, 2};
        int[] sorted = {1, 2, 3, 4, 5};
        Sorter sorter = new SelectionSort();
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }
}