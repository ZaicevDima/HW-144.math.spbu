package com.group144.zaicev;

import static com.group144.zaicev.Spiral.resultArray;

import java.io.PrintWriter;
import java.io.*;

public class PrintFile implements Print {

    @Override
    public void printSpiral(int[][] array) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("output.txt"));
        int[] result = resultArray(array);

        for (int i = result.length - 1; i >= 0; i--) {
            out.write(result[i] + " ");
        }

        out.close();
    }
}
