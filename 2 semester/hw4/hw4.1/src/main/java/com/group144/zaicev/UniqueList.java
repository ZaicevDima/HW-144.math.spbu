package com.group144.zaicev;

/**
 * Unique one-linked list, which works with non-repeating elements any types
 * @param <Type> type your elements
 */
public class UniqueList<Type> extends LinkedList<Type> {

    /**
     * Special method, which adds non-repeating elements
     * @param value value your element
     * @throws ElementIsRepeatException if value your element was repeated
     */
    @Override
    public void add(Type value) throws ElementIsRepeatException {
        if (this.contains(value)) {
            throw new ElementIsRepeatException("Element is repeat");
        }
        super.add(value);
    }
}
