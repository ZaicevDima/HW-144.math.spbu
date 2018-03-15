package com.group144.zaicev;

import java.io.PrintWriter;
import java.io.*;

public class PrintFile implements Print {
    @Override
    public int[] printSpiral(int[][] array) throws FileNotFoundException {
        Spiral spiral = new Spiral();
        PrintWriter out = new PrintWriter(new File("output.txt"));
        int[] result = Spiral.resultArray(array);

        for (int aResult : result) {
            out.write(aResult + " ");
        }

        out.close();
        return result;
    }
}