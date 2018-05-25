package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static com.group144.zaicev.SecondPartTasks.*;
import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class SecondPartTasksTest {

    @Test
    public void testFindQuotes() {
        Assert.assertEquals(Arrays.asList("hello world", "hell"), findQuotes(Arrays.asList("hello world", "test", "hell"), "hel"));

        Assert.assertEquals(Arrays.asList("zaq2018", "qwezaq1"), findQuotes(Arrays.asList("zaq2018", "qwe", "qwezaq1", "q123we"), "zaq"));

        Assert.assertEquals(Arrays.asList("123123", "123456789", "13"), findQuotes(Arrays.asList("123123", "123456789", "000", "777", "13"), "1"));
    }

    @Test
    public void testPiDividedBy4() {
        Assert.assertTrue(abs(piDividedBy4() - PI / 4) < 0.001);
    }

    @Test
    public void testFindPrinter() {
        Map<String, List<String>> compositions = new HashMap<>();

        compositions.put("Alex", Arrays.asList("123", "0000000"));
        compositions.put("Bob", Arrays.asList("Hello world!!!", "123"));
        Assert.assertEquals("Bob", findPrinter(compositions));

        compositions.put("Cara", Arrays.asList("one, two, three", "2018aaaaaaaaaaaaaaa"));
        Assert.assertEquals("Cara", findPrinter(compositions));

        compositions.put("Dan", Collections.singletonList("lol"));
        Assert.assertEquals("Cara", findPrinter(compositions));
    }

    @Test
    public void testCalculateGlobalOrder() {
        List<Map<String, Integer>> orders = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            orders.add(new HashMap<>());
        }

        orders.get(0).put("Apples", 10);
        orders.get(0).put("Bananas", 5);
        orders.get(0).put("Oranges", 3);
        orders.get(0).put("Nuts", 14);

        orders.get(1).put("Apples", 100);
        orders.get(1).put("Bananas", 1);

        orders.get(2).put("Bananas", 50);
        orders.get(2).put("Oranges", 10);

        Map<String, Integer> EXPECTED = new HashMap<>();
        EXPECTED.put("Apples", 110);
        EXPECTED.put("Bananas", 56);
        EXPECTED.put("Oranges", 13);
        EXPECTED.put("Nuts", 14);

        Assert.assertEquals(EXPECTED, SecondPartTasks.calculateGlobalOrder(orders));
    }
}
