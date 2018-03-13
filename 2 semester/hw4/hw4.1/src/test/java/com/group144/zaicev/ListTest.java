package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {

    @Test(expected = NotFoundException.class)
    public void delete() throws NotFoundException, ElementIsRepeat {
        List<Integer> list = new ListLinked<>();
        list.add(1);
        list.delete(1);
        Assert.assertFalse(list.contains(1));
        Assert.assertEquals(0, list.getSize());
        list.delete(1);
    }

    @Test(expected = NotFoundException.class)
    public void deletedNonexistentElementTest() throws NotFoundException {
        List<Integer> list = new ListLinked<>();
        list.delete(1);
    }

    @Test
    public void contains() throws ElementIsRepeat {
        List<Integer> list = new ListLinked<>();
        list.add(1);
        Assert.assertTrue(list.contains(1));
        Assert.assertFalse(list.contains(0));
    }

    @Test
    public void add() throws ElementIsRepeat {
        List<Integer> list = new ListLinked<>();
        Assert.assertFalse(list.contains(1));
        list.add(1);
        Assert.assertTrue(list.contains(1));
    }

    @Test
    public void getSize() throws ElementIsRepeat {
        List<Integer> list = new ListLinked<>();
        Assert.assertEquals(0, list.getSize());
        list.add(1);
        Assert.assertEquals(1, list.getSize());
        list.add(1);
        Assert.assertEquals(2, list.getSize());
        list.add(2);
        Assert.assertEquals(3, list.getSize());
    }

    @Test
    public void clear() throws ElementIsRepeat {
        List<Integer> list = new ListLinked<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        Assert.assertTrue(list.getSize() == 0);
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void isEmpty() throws ElementIsRepeat {
        List<Integer> list = new ListLinked<>();
        Assert.assertTrue(list.isEmpty());
        list.add(1);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void valueOfIndex() throws ElementIsRepeat {
        List<Integer> list = new ListLinked<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertTrue(list.valueOfIndex(1) == 2);
    }
}