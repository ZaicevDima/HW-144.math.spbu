package com.group144.zaicev;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for working with AVL Tree iterator of any type
 *
 * @param <Type> Type, which you want to use in your AVL Tree
 */
public class AVLIterator<Type extends Comparable<Type>> implements Iterator<Type> {
    private AVLTreeNode<Type> next;

    /**
     * Realize the AVL Tree iterator
     *
     * @param node current node
     */
    AVLIterator(AVLTreeNode<Type> node) {
        next = node;
        if (next == null) {
            return;
        }
        while (next.getLeft() != null) {
            next = next.getLeft();
        }
    }

    /**
     * Checks if there is next node
     */
    @Override
    public boolean hasNext() {
        return next != null;
    }

    /**
     * Returns value next node
     */
    @Override
    public Type next() {
        if (!hasNext()) throw new NoSuchElementException();
        AVLTreeNode<Type> result = next;

        if (next.getRight() != null) {
            next = next.getRight();
            while (next.getLeft() != null)
                next = next.getLeft();
            return result.getValue();
        }

        while (true) {
            if (next.getParent() == null) {
                next = null;
                return result.getValue();
            }
            if (next.getParent().getLeft() == next) {
                next = next.getParent();
                return result.getValue();
            }
            next = next.getParent();
        }
    }
}
