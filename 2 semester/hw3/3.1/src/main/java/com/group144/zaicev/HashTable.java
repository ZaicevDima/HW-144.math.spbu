package com.group144.zaicev;

import java.lang.String;

public class HashTable implements HashTableInterface {
    private int tableSize = 10000;
    private LinkedList<String>[] list = (LinkedList<String> []) new LinkedList[tableSize];
    private HashFunction hashFunction;

    /**
     * Class, which create hash table
     * @param hashFunction - hash function that is selected by the user
     */
    HashTable(HashFunction hashFunction) {
        this.hashFunction = hashFunction;
        for (int i = 0; i < tableSize; i++) {
            list[i] = new LinkedList<>();
        }
    }

    @Override
    public void add(String value) {
        int index = hashFunction.hash(value, tableSize);
        list[index].add(value);
    }

    @Override
    public void delete(String value) throws ValueNotFound {
        int index = hashFunction.hash(value, tableSize);
        list[index].delete(value);
    }

    @Override
    public void getInformation() throws ListIsEmptyException {
        int amountWords = 0;
        int amountEmptyList = 0;
        int maxSize = 0;
        int indexMaxList = 0;

        for (int i = 0; i < tableSize; i++) {
            amountWords += list[i].getSize();
            if (list[i].getSize() > maxSize) {
                maxSize = list[i].getSize();
                indexMaxList = i;
            }
            if (list[i].isEmpty()) {
                amountEmptyList++;
            }
        }

        double loadfactor = (double)(tableSize - amountEmptyList) / tableSize;

        System.out.println("amount words = " + amountWords);
        System.out.println("amount empty cells = " + amountEmptyList);
        System.out.println("loadfactor = " + loadfactor);
        System.out.println("max size of lists = " + maxSize);
        System.out.println("index the longest list = " + indexMaxList);
        System.out.println("list :");
        list[indexMaxList].print();
        System.out.println();
    }

    @Override
    public boolean isContains(String value) {
        int index = hashFunction.hash(value, tableSize);
        LinkedList.ListElement temp = list[index].findElement(value);
        System.out.println();
        return temp != null;
    }

    @Override
    public boolean isEmpty() {
        int i = 0;
        while (i < tableSize) {
            if (!list[i].isEmpty()) {
                return false;
            }
            i++;
        }
        return true;
    }
}