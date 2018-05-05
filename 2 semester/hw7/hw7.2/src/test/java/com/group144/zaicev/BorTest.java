package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BorTest extends Bor {

    @Test
    public void addTest() throws IncorrectSymbolException {
        Bor bor = new Bor();
        Assert.assertTrue(bor.add("hello"));
        Assert.assertTrue(bor.add("world"));
        Assert.assertTrue(bor.add("hell"));
        Assert.assertFalse(bor.add("world"));
        Assert.assertEquals(3, bor.size());
    }

    @Test (expected = IncorrectSymbolException.class)
    public void addWithIncorrectSymbolTest() throws IncorrectSymbolException {
        Bor bor = new Bor();
        Assert.assertTrue(bor.add("hello1"));
    }

    @Test
    public void containsTest() throws IncorrectSymbolException {
        Bor bor = new Bor();
        bor.add("hello");
        bor.add("world");
        Assert.assertTrue(bor.contains("world"));
        Assert.assertFalse(bor.contains("wo"));
        Assert.assertFalse(bor.contains("lol"));
    }

    @Test
    public void removeTest() throws IncorrectSymbolException {
        Bor bor = new Bor();
        bor.add("hello");
        bor.add("world");
        Assert.assertEquals(2, bor.size());
        Assert.assertTrue(bor.remove("world"));
        Assert.assertEquals(1, bor.size());
        Assert.assertFalse(bor.remove("hell"));
        Assert.assertEquals(1, bor.size());
        Assert.assertTrue(bor.remove("hello"));
        Assert.assertEquals(0, bor.size());
    }

    @Test
    public void sizeTest() throws IncorrectSymbolException {
        Bor bor = new Bor();
        bor.add("hello");
        bor.add("world");
        bor.add("hell");
        bor.add("w");
        Assert.assertEquals(4, bor.size());
    }

    @Test
    public void howManyStartWithPrefixTest() throws IncorrectSymbolException {
        Bor bor = new Bor();
        bor.add("hello");
        bor.add("world");
        bor.add("hell");
        bor.add("w");
        Assert.assertEquals(2, bor.howManyStartWithPrefix("he"));
        Assert.assertEquals(1, bor.howManyStartWithPrefix("hello"));
        Assert.assertEquals(0, bor.howManyStartWithPrefix("lol"));
        Assert.assertEquals(0, bor.howManyStartWithPrefix("hella"));
    }

    @Test
    public void serializeAndDeserializeTest() throws IncorrectSymbolException, IOException, ClassNotFoundException {
        Bor bor = new Bor();
        bor.add("hello");
        bor.add("world");
        bor.add("hell");
        bor.add("w");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bor.serialize(outputStream);
        bor.add("new");
        bor.add("lol");
        bor.remove("world");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        bor.deserialize(inputStream);
        Assert.assertEquals(4, bor.size());
        Assert.assertTrue(bor.contains("world"));
        Assert.assertFalse(bor.contains("lol"));
    }
}