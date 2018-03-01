package com.group144.zaicev;

public class Spiral {
    public static int[] resultArray(int[][] array) {
        int length = array.length;
        int[] result = new int[length * length];
        int currentIndex = 0;
        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < length - i - 1; j++) {
                result[currentIndex] = array[i][j];
                currentIndex++;
            }
            for (int j = i; j < length - i - 1; j++) {
                result[currentIndex] = array[j][length - i - 1];
                currentIndex++;
            }
            for (int j = i; j < length - i - 1; j++) {
                result[currentIndex] = array[length - i - 1][length - j - 1];
                currentIndex++;
            }
            for (int j = i; j < length - i - 1; j++) {
                result[currentIndex] = array[length - j - 1][i];
                currentIndex++;
            }
        }
        result[currentIndex] = array[length / 2][length / 2];

        return result;
    }
}
