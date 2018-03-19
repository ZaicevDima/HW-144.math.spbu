package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void containsExistingElementTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        Assert.assertTrue(list.contains(1));
    }

    @Test
    public void containsNonExistingElementTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        Assert.assertFalse(list.contains(0));
    }

    @Test
    public void addTest() {
        LinkedList<Integer> list = new LinkedList<>();
        Assert.assertFalse(list.contains(1));
        list.add(1);
        Assert.assertTrue(list.contains(1));

        Assert.assertFalse(list.contains(2));
        list.add(2);
        Assert.assertTrue(list.contains(2));
    }

    @Test
    public void getSizeTest() throws ValueNotFound {
        LinkedList<Integer> list = new LinkedList<>();
        Assert.assertEquals(0, list.getSize());
        list.add(1);
        Assert.assertEquals(1, list.getSize());
        list.add(1);
        Assert.assertEquals(2, list.getSize());
        list.add(2);
        Assert.assertEquals(3, list.getSize());
        list.delete(1);
        Assert.assertEquals(2, list.getSize());
    }

    @Test ()
    public void deleteTest() throws ValueNotFound {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.delete(1);
        Assert.assertFalse(list.contains(1));
        Assert.assertEquals(0, list.getSize());

        list.add(1);
        list.add(2);
        list.add(3);
        list.delete(2);
        Assert.assertFalse(list.contains(2));
        Assert.assertEquals(2, list.getSize());

        list.delete(3);
        Assert.assertFalse(list.contains(3));
        Assert.assertEquals(1, list.getSize());
    }

    @Test(expected = ValueNotFound.class)
    public void deletedNonExistingElementTest() throws ValueNotFound {
        LinkedList<Integer> list = new LinkedList<>();
        list.delete(1);
    }

    @Test
    public void clearTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void valueOfIndexTest() throws IndexBeyondBorders {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Assert.assertTrue(list.valueOfIndex(0) == 1);
        Assert.assertTrue(list.valueOfIndex(1) == 2);
        Assert.assertTrue(list.valueOfIndex(3) == 4);
    }

    @Test(expected = IndexBeyondBorders.class)
    public void valueOfIndexIncorrectIndexTest() throws IndexBeyondBorders {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(10);
        list.valueOfIndex(6);
    }

    @Test
    public void findElementTest(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        Assert.assertTrue(list.findElement(1).value == 1);
        list.add(2);
        Assert.assertTrue(list.findElement(2).value == 2);
        Assert.assertTrue(list.findElement(4) == null);
    }

    @Test
    public void isEmptyTest() {
        LinkedList<Integer> list = new LinkedList<>();
        Assert.assertTrue(list.isEmpty());
        list.add(1);
        Assert.assertFalse(list.isEmpty());
    }

    @Test (expected = ListIsEmptyException.class)
    public void printTest() throws ListIsEmptyException {
        LinkedList<Integer> list = new LinkedList<>();
        list.print();
    }
}