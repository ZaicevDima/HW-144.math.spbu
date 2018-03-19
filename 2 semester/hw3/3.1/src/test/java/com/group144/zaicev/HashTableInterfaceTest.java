package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

public class HashTableInterfaceTest {
    private HashTable hashTable1 = new HashTable(new LengthHashFunction());
    private HashTable hashTable2 = new HashTable(new PolynomialHashFunction());

    @Test
    public void addTest() {
        Assert.assertFalse(hashTable1.isContains("lol"));
        Assert.assertFalse(hashTable2.isContains("lol"));

        hashTable1.add("lol");
        hashTable2.add("lol");

        Assert.assertTrue(hashTable1.isContains("lol"));
        Assert.assertTrue(hashTable2.isContains("lol"));
    }

    @Test (expected = ValueNotFound.class)
    public void deleteTest() throws ValueNotFound {
        hashTable1.add("lol");
        hashTable2.add("lol");

        hashTable1.delete("lol");
        hashTable2.delete("lol");
        Assert.assertFalse(hashTable1.isContains("lol"));
        Assert.assertFalse(hashTable2.isContains("lol"));

        hashTable1.delete("a");
    }

    @Test
    public void isContainsValueTest() {
        Assert.assertFalse(hashTable1.isContains("wow"));
        Assert.assertFalse(hashTable2.isContains("wow"));

        hashTable1.add("lol");
        hashTable2.add("lol");
        hashTable1.add("wow");
        hashTable2.add("wow");

        Assert.assertTrue(hashTable1.isContains("wow"));
        Assert.assertTrue(hashTable2.isContains("wow"));
    }

    @Test
    public void isEmptyTest() throws ValueNotFound {
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
    public void getInformationEmptyTableTest() throws ValueNotFound, ListIsEmptyException {
        hashTable1.add("a");
        hashTable1.delete("a");

        hashTable1.getInformation();
    }
}