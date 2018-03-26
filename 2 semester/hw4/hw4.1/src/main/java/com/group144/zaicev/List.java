package com.group144.zaicev;

/**
 * interface for work with List which have elements any type
 *
 * @param <Type> element's type your List
 */
public interface List<Type> {

    /**
     * method, which removes list element by the value
     * @param value value, which you want remove
     * @throws ValueNotFoundException if value didn't found in the list
     */
    void delete(Type value) throws ValueNotFoundException;

    /**
     * method, which checks if there is a given element in the list
     * @param element value, which you check
     * @return true if your value in the list, else false
     */
    boolean contains(Type element);

    /**
     * method, which adds value in the list
     * @param value value, which you want add
     * @throws ElementIsRepeatException if you are adding value repeat
     */
    void add(Type value) throws ElementIsRepeatException;

    /**
     * method, which returns size your list
     * @return size your list
     */
    int getSize();

    /**
     * method, with clears your list
     */
    void clear();

    /**
     * method, which checks if list is empty
     * @return true, if list is empty, else return false
     */
    boolean isEmpty();

    /**
     * method, which returns value from the list at your index
     * @param index index, index by which you want to know the meaning
     * @return value from the list
     * @throws IndexBeyondBordersException if index beyond borders
     */
    Type valueOfIndex(int index) throws IndexBeyondBordersException;
}
