package com.group144.zaicev;

import java.lang.String;

/**
 * Interface for work with hash table
 */
public interface HashTableInterface {

    /**
     * Method, which add value in your hash table
     * @param value - value, which you want add
     */
    void add(String value);

    /**
     * Method, which remove value from your hash table
     * @param value - value, which you want remove
     * @throws ValueNotFoundException , if your value is not found
     */
    void delete(String value) throws ValueNotFoundException;

    /**
     * Method, which give you information about hash table
     *
     * give you amount of words in hash table,
     * max amount of words in cell hash table,
     * amount of empty cells in hash table,
     * print load factor,
     * print index the longest cell and element from this cell
     *
     * @throws ListIsEmptyException , when you want print empty cell
     */
    void getInformation() throws ListIsEmptyException;

    /**
     * Method that checks if your value is in a hash table
     * @param value - value, which you want check
     * @return true, if your value is contains in hash table, else false
     */
    boolean contains(String value) throws ListIsEmptyException;

    /**
     * Method that checks if hash table is empty
     * @return true, if hash table is empty, else false
     */
    boolean isEmpty();
}
