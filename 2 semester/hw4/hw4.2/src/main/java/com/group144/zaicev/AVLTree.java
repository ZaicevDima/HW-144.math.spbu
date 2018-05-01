package com.group144.zaicev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Class for working with AVL Tree of any type
 *
 * @param <Type> Type which you want to use in your AVL Tree
 */
public class AVLTree<Type extends Comparable<Type>> implements Collection<Type> {

    private AVLTreeNode<Type> root;
    private int size;

    /**
     * Constructor AVL Tree
     */
    AVLTree() {
        root = null;
        size = 0;
    }

    /**
     * Changes the value of a root
     *
     * @param node node, which will be the new root
     */
    void setRoot(AVLTreeNode<Type> node) {
        root = node;
    }

    /**
     * Returns the value of a root
     */
    AVLTreeNode<Type> getRoot() {
        return root;
    }

    /**
     * Changes the value of a size
     *
     * @param value value, which will be the new size
     */
    void setSize(int value) {
        size = value;
    }

    /**
     * Returns the  AVL Tree size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the AVL Tree is empty
     *
     * @return true, if AVL Tree is empty, else false
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Checks if the AVL Tree contains this value
     *
     * @param value value, which you want to check
     * @return true, if the tree contains this value, else false
     */
    @Override
    public boolean contains(Object value) {
        return root.isContainsNode((Type) value, this);
    }

    /**
     * Returns iterator in the collection in increasing order
     */
    @Override
    public Iterator<Type> iterator() {
        return new AVLIterator<>(root);
    }

    /**
     * Returns array, which contains all elements of the collection in increasing order
     */
    @Override
    public Object[] toArray() {
        return toArray(new Object[size]);
    }

    /**
     * Returns array, which contains all elements of the collection in increasing order
     *
     * @param array   in which element from the collection will be added
     * @param <Type1> type of the array
     */
    @Override
    public <Type1> Type1[] toArray(Type1[] array) {
        ArrayList<Type1> arrayList = new ArrayList<>();
        for (Type tmp : this) {
            arrayList.add((Type1) tmp);
        }

        return arrayList.toArray(array);
    }

    /**
     * Adds a value to the AVL Tree
     *
     * @param value value, which you want to add
     * @return false, if the tree contains this value before adding, else true
     */
    @Override
    public boolean add(Type value) {
        if (root == null) {
            root = new AVLTreeNode<>(value, null);
            size = 1;
            return true;
        } else {
            if (contains(value)) {
                return false;
            }
            size++;
            root.addNode(value, this);
            return true;
        }
    }

    /**
     * Removes a value from the AVL Tree
     *
     * @param value value, which you want to remove
     * @return false, if the tree doesn't contain this value, else true
     */
    @Override
    public boolean remove(Object value) {
        if (contains(value)) {
            root.removeNode((Type) value, this);
            return true;
        }
        return false;
    }

    /**
     * Contains all element from the collection
     *
     * @param collection your collection with elements
     * @return true, if the tree contains all elements from this collection
     */
    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean result = true;
        for (Object temp : collection) {
            result = result && contains(temp);
        }
        return result;
    }

    /**
     * Adds all elements from the collection
     *
     * @param collection your collection with elements
     * @return false if after adding there is element, which repeated, else true
     */
    @Override
    public boolean addAll(Collection<? extends Type> collection) {
        boolean result = true;
        for (Type temp : collection) {
            result = result && add(temp);
        }
        return result;
    }

    /**
     * Removes from tree all elements of the collection
     *
     * @param collection your collection with elements
     * @return true, if tree contains all elements of the collection, else false
     */
    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean result = true;
        for (Object temp : collection) {
            result = result && remove(temp);
        }
        return result;
    }

    /**
     * Retains from tree all elements, which there is in the collection
     *
     * @param collection your collection with elements
     * @return false, if there is element, which is contained in the collection, but not in the tree, else true
     */
    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean result = false;
        for (Type tmp : this) {
            if (!collection.contains(tmp)) {
                remove(tmp);
                result = true;
            }
        }
        return result;
    }

    /**
     * Clears AVL Tree
     */
    @Override
    public void clear() {
        root = null;
    }

    /**
     * Converts the tree to the string
     */
    @Override
    public String toString() {
        if (!isEmpty()) {
            return root.toString();
        } else {
            return "null";
        }
    }

}