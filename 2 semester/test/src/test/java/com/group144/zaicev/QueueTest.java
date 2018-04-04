package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void enqueue() {
        Queue<Integer> queue = new Queue<>();
        Assert.assertFalse(queue.isContains(1, 5));
        queue.enqueue(1, 5);
        Assert.assertTrue(queue.isContains(1, 5));
        queue.enqueue(2, 1);
        Assert.assertFalse(queue.isContains(1, 2));
        queue.enqueue(1, 2);
        Assert.assertTrue(queue.isContains(1,2));
    }

    @Test
    public void dequeue() throws QueueIsEmpty {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1, 3);
        queue.enqueue(5, 10);
        queue.enqueue(11, 1);

        int value = queue.dequeue();
        Assert.assertEquals(5, value);
        value = queue.dequeue();
        Assert.assertEquals(1, value);
        value = queue.dequeue();
        Assert.assertEquals(11, value);

        queue.enqueue(1, 2);
        queue.enqueue(5, 3);
        queue.enqueue(11, 10);
        value = queue.dequeue();
        Assert.assertEquals(11, value);
    }

    @Test (expected = QueueIsEmpty.class)
    public void dequeueFromEmptyQueue() throws QueueIsEmpty {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(-1, 3);

        queue.dequeue();
        queue.dequeue();
    }

    @Test (expected = QueueIsEmpty.class)
    public void queueForString() throws QueueIsEmpty {
        Queue<String> queue = new Queue<>();
        queue.enqueue("aaa", 5);
        Assert.assertTrue(queue.isContains("aaa", 5));
        queue.enqueue("2", 1);
        queue.enqueue("bbb1", 2);
        Assert.assertTrue(queue.isContains("bbb1",2));

        String value = queue.dequeue();
        Assert.assertEquals("aaa", value);
        value = queue.dequeue();
        Assert.assertEquals("bbb1", value);

        queue.dequeue();
        queue.dequeue();
    }
}