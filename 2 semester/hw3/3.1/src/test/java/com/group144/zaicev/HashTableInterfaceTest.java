package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

public class HashTableInterfaceTest {
    private HashTable hashTable1 = new HashTable(new LengthHashFunction());
    private HashTable hashTable2 = new HashTable(new PolynomialHashFunction());

    @Test
    public void addTest() throws ListIsEmptyException {
        Assert.assertFalse(hashTable1.contains("lol"));
        Assert.assertFalse(hashTable2.contains("lol"));

        hashTable1.add("lol");
        hashTable2.add("lol");

        Assert.assertTrue(hashTable1.contains("lol"));
        Assert.assertTrue(hashTable2.contains("lol"));
    }

    @Test (expected = ValueNotFoundException.class)
    public void deleteTest() throws ValueNotFoundException, ListIsEmptyException {
        hashTable1.add("lol");
        hashTable2.add("lol");

        hashTable1.delete("lol");
        hashTable2.delete("lol");
        Assert.assertFalse(hashTable1.contains("lol"));
        Assert.assertFalse(hashTable2.contains("lol"));

        hashTable1.delete("a");
    }

    @Test
    public void containsValueTest() throws ListIsEmptyException {
        Assert.assertFalse(hashTable1.contains("wow"));
        Assert.assertFalse(hashTable2.contains("wow"));

        hashTable1.add("lol");
        hashTable2.add("lol");
        hashTable1.add("wow");
        hashTable2.add("wow");

        Assert.assertTrue(hashTable1.contains("lol"));
        Assert.assertTrue(hashTable2.contains("lol"));
        Assert.assertTrue(hashTable1.contains("wow"));
        Assert.assertTrue(hashTable2.contains("wow"));
    }

    @Test
    public void isEmptyTest() throws ValueNotFoundException {
        hashTable1.add("a");
        Assert.assertFalse(hashTable1.isEmpty());
        hashTable1.delete("a");

        hashTable2.add("a");
        Assert.assertFalse(hashTable2.isEmpty());
        hashTable2.delete("a");

        Assert.assertTrue(hashTable1.isEmpty());
        Assert.assertTrue(hashTable2.isEmpty());
    }

    @Test (expected = ListIsEmptyException.class)
    public void getInformationEmptyTableTest() throws ValueNotFoundException, ListIsEmptyException {
        hashTable1.add("a");
        hashTable1.delete("a");

        hashTable1.getInformation();
    }
}