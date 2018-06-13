package com.group144.zaicev;

import java.util.function.Supplier;

/**
 * Class, which realizes method get() for single thread and multi thread
 */
public class LazyFactory {

    /**
     * Realizes method get() for single thread
     *
     * @param supplier function, which will be used
     * @param <Type>   Type, which returns method get()
     * @return result your function
     */
    public static <Type> Lazy<Type> createLazySingleThread(Supplier<Type> supplier) {
        return new Lazy<Type>() {
            private Type value = null;
            boolean isPerformed = false;

            @Override
            public Type get() {
                if (!isPerformed) {
                    if (supplier == null) {
                        value = null;
                    } else {
                        value = supplier.get();
                    }
                    isPerformed = true;
                }
                return value;
            }
        };
    }

    /**
     * Realizes method get() for multi thread
     *
     * @param supplier function, which will be used
     * @param <Type>   Type, which returns method get()
     * @return result your function
     */
    public static <Type> Lazy<Type> createLazyMultiThread(Supplier<Type> supplier) {
        return new Lazy<Type>() {
            volatile boolean isPerformed = false;
            private volatile Type value = null;

            @Override
            public Type get() {
                if (!isPerformed) {
                    synchronized (this) {
                        if (!isPerformed) {
                            if (supplier == null) {
                                value = null;
                            } else {
                                value = supplier.get();
                            }
                            isPerformed = true;
                        }
                    }
                }
                return value;
            }
        };
    }
}
