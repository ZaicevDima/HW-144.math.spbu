package group144.zaicev;

public class SelectionSort implements Sorts {

    @Override
    public void sort(int[] array) {
        int min = 0;
        int temp = 0;

        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }
}
