package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AVLIteratorTest {

    private AVLTree<String> tree = new AVLTree<>();

    @Test
    public void IteratorTest() {
        tree.add("0");
        tree.add("3");
        tree.add("8");
        tree.add("7");
        tree.add("2");
        tree.add("4");
        tree.add("6");
        tree.add("5");

        Iterator<String> iterator = tree.iterator();
        Assert.assertTrue(iterator.hasNext());
        String EXPECTED1 = "0";
        Assert.assertEquals(EXPECTED1, iterator.next());
        String EXPECTED2 = "2";
        Assert.assertEquals(EXPECTED2, iterator.next());
        String EXPECTED3 = "3";
        Assert.assertEquals(EXPECTED3, iterator.next());
        String EXPECTED4 = "4";
        Assert.assertEquals(EXPECTED4, iterator.next());
        String EXPECTED5 = "5";
        Assert.assertEquals(EXPECTED5, iterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void ErrorTest() {
        Iterator<String> iterator = tree.iterator();
        iterator.next();
        iterator.next();
    }
}