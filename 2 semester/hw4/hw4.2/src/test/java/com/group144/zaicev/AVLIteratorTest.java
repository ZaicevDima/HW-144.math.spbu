package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class AVLIteratorTest {

    private AVLTree<String> tree = new AVLTree<>();

    @Test
    public void compareTo() {
        tree.add("1");
        tree.add("2");
        tree.add("3");

        Iterator<String> iterator = tree.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("1", iterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void Error() {
        Iterator<String> iterator = tree.iterator();
        iterator.next();
        iterator.next();
    }
}