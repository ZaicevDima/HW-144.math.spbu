package com.group144.zaicev;

import org.junit.Test;

import java.util.ArrayList;

import static com.group144.zaicev.LazyFactory.createLazyMultiThread;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LazyTest {

    @Test
    public void singleThreadSimpleTest() {
        Lazy<Integer> lazy = LazyFactory.createLazySingleThread(() -> 5);

        lazy.get();
        lazy.get();

        assertEquals(5, lazy.get().intValue());
    }

    @Test
    public void nullValueThreadSimpleTest() {
        Lazy<String> lazy = LazyFactory.createLazySingleThread(() -> null);

        assertEquals(null, lazy.get());
    }

    @Test
    public void nullThreadSimpleTest() {
        Lazy<Integer> lazy = LazyFactory.createLazySingleThread(null);

        assertEquals(null, lazy.get());
    }

    @Test
    public void singleThreadMultiTest() throws Exception {
        final boolean[] isFailed = {false};

        Lazy<Integer> lazy = createLazyMultiThread(() -> 5);
        Runnable check = () -> isFailed[0] = isFailed[0] || (lazy.get() != 5);

        Thread firstThread = new Thread(check);
        Thread secondThread = new Thread(check);

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        assertFalse(isFailed[0]);
        assertEquals(5, lazy.get().intValue());
    }

    @Test
    public void nullValueThreadMultiTest() throws InterruptedException {
        final boolean[] isFailed = {false};

        Lazy<Integer> lazy = LazyFactory.createLazySingleThread(() -> null);
        Runnable check = () -> isFailed[0] = isFailed[0] || (lazy.get() != null);

        Thread first = new Thread(check);
        Thread second = new Thread(check);

        first.start();
        second.start();

        first.join();
        second.join();

        assertFalse(isFailed[0]);
        assertEquals(null, lazy.get());
    }

    @Test
    public void nullThreadMultiTest() {
        Lazy<Integer> lazy = LazyFactory.createLazyMultiThread(null);

        assertEquals(null, lazy.get());
    }

    @Test
    public void raceThreadMultiTest() throws InterruptedException {
        ArrayList<String> strings = new ArrayList<>();

        Lazy<Boolean> lazy = createLazyMultiThread(() -> {
            strings.add("Hello World");
            return true;
        });

        Runnable check = () -> {
            for (int i = 0; i < 100; i++) {
                lazy.get();
            }
        };

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(check));
            threads.get(i).start();
        }

        for (int i = 0; i < 10; i++) {
            threads.get(i).join();
        }

        assertEquals(1, strings.size());
        assertEquals("Hello World", strings.get(0));
    }
}
