package group144.zaicev;

public class InsertionSort implements Sorter {

    @Override
    public void sort(int[] array) {
        int n = array.length;
        int key = 0;
        int j = 0;
        for (int i = 1; i < n; i++) {
            key = array[i];
            j = i - 1;

            while ((j >= 0) && (array[j] > key)) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }
}
