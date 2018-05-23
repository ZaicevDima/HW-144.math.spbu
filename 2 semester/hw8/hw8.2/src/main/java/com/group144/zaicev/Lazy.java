package com.group144.zaicev;

/**
 * Interface, which realizes lazy method get()
 *
 * @param <Type> Type which will return get()
 */
public interface Lazy<Type> {
    Type get();
}
