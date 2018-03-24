package com.group144.zaicev;

class PrintConsole implements Print {
    @Override
    public int[] printSpiral(int[][] array) {
        Spiral spiral = new Spiral();
        int[] result = Spiral.resultArray(array);
        for (int aResult : result) {
            System.out.print(aResult + " ");
        }
        return result;
    }
}