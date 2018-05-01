package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class AVLTreeTest {

    private AVLTree<Integer> tree = new AVLTree<Integer>();

    @Test
    public void size() {
        tree.add(1);
        tree.add(-3);
        tree.add(5);
        Assert.assertEquals(3, tree.size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(tree.isEmpty());
        tree.add(1);
        Assert.assertFalse(tree.isEmpty());
        tree.remove(1);
        Assert.assertTrue(tree.isEmpty());
    }

    @Test
    public void contains() {
    }

    @Test
    public void iterator() {
        AVLTree<String> tree = new AVLTree<>();
        tree.add("LOL");
        tree.add("KEK");
        tree.add("LOL");
        Iterator<String> avlTreeIterator = tree.iterator();
        Assert.assertTrue(avlTreeIterator.hasNext());
        Assert.assertEquals(avlTreeIterator.next(), "KEK");
        Assert.assertEquals(avlTreeIterator.next(), "LOL");
        Assert.assertFalse(avlTreeIterator.hasNext());
    }

    @Test
    public void toArray() {
        tree.add(1);
        tree.add(2);
        tree.add(4);
        tree.add(1);
        tree.add(5);
        tree.add(3);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, tree.toArray());
    }

    @Test
    public void add() {
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
        Assert.assertEquals(5, tree.size());
        Assert.assertTrue(tree.contains(-5));
        Assert.assertTrue(tree.remove(-5));
        Assert.assertEquals(4, tree.size());
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
    public void containsAll() {
        Assert.assertTrue(tree.add(4));
        Assert.assertTrue(tree.add(2));
        Assert.assertTrue(tree.add(6));
        Assert.assertTrue(tree.add(1));
        Assert.assertTrue(tree.contains(4));
        Assert.assertFalse(tree.contains(42));
        Assert.assertTrue(tree.contains(1));

    }

    @Test
    public void addAll() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        tree.addAll(collection);
        Assert.assertTrue(tree.containsAll(collection));
        Assert.assertEquals(collection.size(), tree.size());
    }

    @Test
    public void removeAll() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.removeAll(collection);
        Assert.assertEquals(1, tree.size());
        Assert.assertTrue(tree.contains(3));
    }

    @Test
    public void retainAll() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.retainAll(collection);
        Assert.assertEquals(2, tree.size());
        Assert.assertTrue(tree.contains(1));
        Assert.assertTrue(tree.contains(2));
        Assert.assertFalse(tree.contains(3));
    }

    @Test
    public void clear() {
        tree.add(1);
        tree.add(2);
        tree.add(5);
        tree.add(0);
        Assert.assertFalse(tree.isEmpty());
        tree.clear();
        Assert.assertTrue(tree.isEmpty());
    }

    @Test
    public void emptyTreeToString() {
        Assert.assertEquals("null", tree.toString());
    }

    @Test
    public void treeToStringTest() {
        tree.add(1);
        tree.add(2);
        tree.add(5);
        tree.add(0);
        Assert.assertEquals("( 2 ( 1 ( 0 null null ) null ) ( 5 null null ))", tree.toString());
    }
}