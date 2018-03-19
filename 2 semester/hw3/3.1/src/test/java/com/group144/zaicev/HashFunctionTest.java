package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

import static java.util.Objects.hash;

public class HashFunctionTest {

    @Test
    public void hashLengthHashFunction() {
        HashFunction hashFunction = new LengthHashFunction();
        int tableSize = 10000;
        Assert.assertEquals(1, hashFunction.hash("a", tableSize));
    }

    @Test
    public void hashPolinomialHashFunction() {
        HashFunction hashFunction = new PolynomialHashFunction();
        int tableSize = 10000;
        Assert.assertEquals(97, hashFunction.hash("a", tableSize));
    }
}