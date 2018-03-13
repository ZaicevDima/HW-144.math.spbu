package com.group144.zaicev;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueListTest {

    @Test (expected = ElementIsRepeat.class)
    public void addNumber() throws ElementIsRepeat {
        UniqueList<Integer> list = new UniqueList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        assertTrue(list.valueOfIndex(1) == 2);
    }

    @Test (expected = ElementIsRepeat.class)
    public void addRepeating() throws ElementIsRepeat {
        UniqueList<Integer> list = new UniqueList<>();
        list.add(1);
        list.add(1);
    }

    @Test (expected = ElementIsRepeat.class)
    public void IntegerList() throws ElementIsRepeat, NotFoundException {
        UniqueList<Integer> list = new UniqueList<>();

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

        list.add(1);
        list.add(1);
    }

    @Test (expected = NotFoundException.class)
    public void CharacterList() throws ElementIsRepeat, NotFoundException {
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