package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {

    @Test
    public void deleteExistingElementTest() throws ValueNotFound, ElementIsRepeat {
        List<Integer> list = new LinkedList<>();
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
        List<Integer> list = new LinkedList<>();
        list.delete(1);
    }

    @Test
    public void containsExistingElementTest() throws ElementIsRepeat {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        Assert.assertTrue(list.contains(1));
    }

    @Test
    public void containsNonExistingElementTest() throws ElementIsRepeat {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        Assert.assertFalse(list.contains(0));
    }

    @Test
    public void addTest() throws ElementIsRepeat {
        List<Integer> list = new LinkedList<>();
        Assert.assertFalse(list.contains(1));
        list.add(1);
        Assert.assertTrue(list.contains(1));
    }

    @Test
    public void getSizeTest() throws ElementIsRepeat, ValueNotFound {
        List<Integer> list = new LinkedList<>();
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

    @Test
    public void clearTest() throws ElementIsRepeat {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void isEmptyTest() throws ElementIsRepeat {
        List<Integer> list = new LinkedList<>();
        Assert.assertTrue(list.isEmpty());
        list.add(1);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void valueOfIndexCorrectIndexTest() throws ElementIsRepeat, IndexBeyondBorders {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertTrue(list.valueOfIndex(1) == 2);
    }

    @Test(expected = IndexBeyondBorders.class)
    public void valueOfIndexIncorrectIndexTest() throws ElementIsRepeat, IndexBeyondBorders {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(10);
        list.valueOfIndex(6);
    }

    @Test (expected = IndexBeyondBorders.class)
    public void IntegerListTest() throws ElementIsRepeat, ValueNotFound, IndexBeyondBorders {
        List<Integer> list = new LinkedList<>();

        assertTrue(list.isEmpty());

        list.add(1);
        list.add(2);
        assertTrue(list.getSize() == 2);

        assertTrue(list.contains(2));
        assertFalse(list.contains(4));

        list.delete(2);
        assertFalse(list.contains(2));
        assertTrue(list.getSize() == 1);

        list.add(3);
        assertTrue(list.valueOfIndex(0) == 1);

        list.clear();
        assertFalse(list.contains(1));
        assertFalse(list.contains(3));
        assertTrue(list.getSize() == 0);

        list.valueOfIndex(10);
    }

    @Test (expected = ValueNotFound.class)
    public void CharacterListTest() throws ElementIsRepeat, ValueNotFound, IndexBeyondBorders {
        UniqueList<Character> list = new UniqueList<>();

        assertTrue(list.isEmpty());

        list.add('1');
        list.add('2');
        assertTrue(list.getSize() == 2);

        assertTrue(list.contains('2'));
        assertFalse(list.contains('4'));

        list.delete('2');
        assertFalse(list.contains('2'));
        assertTrue(list.getSize() == 1);

        list.add('3');
        assertTrue(list.valueOfIndex(0) == '1');

        list.clear();
        assertFalse(list.contains('1'));
        assertFalse(list.contains('3'));
        assertTrue(list.getSize() == 0);

        list.delete('5');
    }
}