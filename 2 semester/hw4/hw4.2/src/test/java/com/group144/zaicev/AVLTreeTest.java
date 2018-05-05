package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class AVLTreeTest {

    private AVLTree<Integer> tree = new AVLTree<>();

    @Test
    public void sizeTest() {
        tree.add(1);
        tree.add(-3);
        tree.add(5);
        int EXPECTED = 3;
        Assert.assertEquals(EXPECTED, tree.size());
    }

    @Test
    public void isEmptyTest() {
        Assert.assertTrue(tree.isEmpty());
        tree.add(1);
        Assert.assertFalse(tree.isEmpty());
        tree.remove(1);
        Assert.assertTrue(tree.isEmpty());
    }

    @Test
    public void containsTest() {
        Assert.assertFalse(tree.contains(1));
        tree.add(1);
        Assert.assertTrue(tree.contains(1));
    }

    @Test
    public void iteratorTest() {
        AVLTree<String> tree = new AVLTree<>();
        tree.add("LOL");
        tree.add("707");
        tree.add("LOL");
        Iterator<String> avlTreeIterator = tree.iterator();
        Assert.assertTrue(avlTreeIterator.hasNext());
        String EXPECTED1 = "707";
        Assert.assertEquals(EXPECTED1, avlTreeIterator.next());
        String EXPECTED2 = "LOL";
        Assert.assertEquals(EXPECTED2, avlTreeIterator.next());
        Assert.assertFalse(avlTreeIterator.hasNext());
    }

    @Test
    public void toArrayTest() {
        tree.add(1);
        tree.add(2);
        tree.add(4);
        tree.add(1);
        tree.add(5);
        tree.add(3);
        Integer[] EXPECTED = new Integer[]{1, 2, 3, 4, 5};
        Assert.assertArrayEquals(EXPECTED, tree.toArray());
    }

    @Test
    public void addTest() {
        Assert.assertTrue(tree.add(0));
        Assert.assertTrue(tree.add(-2));
        Assert.assertTrue(tree.add(5));
        Assert.assertTrue(tree.add(-1));
        Assert.assertTrue(tree.add(-5));
        Assert.assertTrue(tree.add(2));
        Assert.assertTrue(tree.add(7));
        Assert.assertTrue(tree.add(6));
        Assert.assertTrue(tree.add(-4));
        Assert.assertTrue(tree.add(-3));
        Assert.assertFalse(tree.add(0));
    }

    @Test
    public void removeTest() {
        tree.add(4);
        tree.add(-5);
        tree.add(5);
        tree.add(1);
        tree.add(-100);
        tree.add(5);
        int EXPECTED1 = 5;
        Assert.assertEquals(EXPECTED1, tree.size());
        Assert.assertTrue(tree.contains(-5));
        Assert.assertTrue(tree.remove(-5));
        int EXPECTED2 = 4;
        Assert.assertEquals(EXPECTED2, tree.size());
        Assert.assertFalse(tree.contains(-5));
        Assert.assertFalse(tree.remove(101));
        tree.add(0);
        Assert.assertTrue(tree.remove(5));
        Assert.assertTrue(tree.remove(0));
    }

    @Test
    public void removeRootTest() {
        tree.add(1);
        tree.add(0);
        Assert.assertTrue(tree.remove(1));
        tree.add(-5);
        tree.add(1);
        tree.add(2);
        tree.add(-10);
        tree.add(-2);
        tree.add(-1);
        tree.add(-4);
        tree.add(-15);
        tree.add(-20);
        Assert.assertTrue(tree.remove(-2));
        Assert.assertTrue(tree.remove(-20));
    }

    @Test
    public void containsAllTest() {
        Assert.assertTrue(tree.add(4));
        Assert.assertTrue(tree.add(2));
        Assert.assertTrue(tree.add(6));
        Assert.assertTrue(tree.add(1));
        Assert.assertTrue(tree.contains(4));
        Assert.assertFalse(tree.contains(42));
        Assert.assertTrue(tree.contains(1));

    }

    @Test
    public void addAllTest() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        tree.addAll(collection);
        Assert.assertTrue(tree.containsAll(collection));
        int EXPECTED = 3;
        Assert.assertEquals(EXPECTED, tree.size());
    }

    @Test
    public void removeAllTest() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.removeAll(collection);
        int EXPECTED = 1;
        Assert.assertEquals(EXPECTED, tree.size());
        Assert.assertTrue(tree.contains(3));
    }

    @Test
    public void retainAllTest() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.retainAll(collection);
        int EXPECTED = 2;
        Assert.assertEquals(EXPECTED, tree.size());
        Assert.assertTrue(tree.contains(1));
        Assert.assertTrue(tree.contains(2));
        Assert.assertFalse(tree.contains(3));
    }

    @Test
    public void clearTest() {
        tree.add(1);
        tree.add(2);
        tree.add(5);
        tree.add(0);
        Assert.assertFalse(tree.isEmpty());
        tree.clear();
        Assert.assertTrue(tree.isEmpty());
    }

    @Test
    public void emptyTreeToStringTest() {
        String EXPECTED = "null";
        Assert.assertEquals(EXPECTED, tree.toString());
    }

    @Test
    public void treeToStringTest() {
        tree.add(1);
        tree.add(2);
        tree.add(5);
        tree.add(0);
        String EXPECTED = "( 2 ( 1 ( 0 null null ) null ) ( 5 null null ))";
        Assert.assertEquals(EXPECTED, tree.toString());
    }
}