package com.group144.zaicev;

import static com.group144.zaicev.Spiral.resultArray;

public class PrintConcole implements Print{
    @Override
    public void printSpiral(int[][] array) {
        int[] result = resultArray(array);
        for (int i = result.length - 1; i >= 0; i--) {
            System.out.print(result[i] + " ");
        }
    }
}
