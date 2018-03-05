package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PrintTest {

    private int[][] array = {{11, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private String correct = "5 4 7 8 9 6 3 2 11 ";

    @Test
    public void printSpiralConsole() throws FileNotFoundException {
        int[] result = Spiral.resultArray(array);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        PrintStream console = System.out;

        System.setOut(printStream);

        Print output = new PrintConsole();
        output.printSpiral(array);

        System.out.flush();
        System.setOut(console);

        Assert.assertTrue(stream.toString().equals(correct));
    }

    @Test
    public void printSpiralFile() throws FileNotFoundException {
        Print output = new PrintFile();
        output.printSpiral(array);
        Scanner in = new Scanner(new File("output.txt"));
        String result = in.nextLine();
        Assert.assertTrue(result.equals(correct));
    }
}