package com.group144.zaicev;

import java.lang.String;

public class HashTable implements HashTableInterface {
    private int tableSize = 10000;
    private LinkedList<String>[] list = (LinkedList<String> []) new LinkedList[tableSize];
    private HashFunction hashFunction;

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
    public void getInformation() {
        int amountWords = 0;
        int amountEmptyList = 0;
        int maxSize = 0;
        int indexMaxList = -1;

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
        System.out.println("amount empty list = " + amountEmptyList);
        System.out.println("loadfactor = " + loadfactor);
        System.out.println("max size of lists = " + maxSize);
        System.out.println("index the longest list = " + indexMaxList);
        System.out.println("list :");
        list[indexMaxList].print();
    }

    @Override
    public void findValue(String value) {
        int index = hashFunction.hash(value, tableSize);
        LinkedList.ListElement temp = list[index].foundElement(value);
        list[index].print();
        System.out.println();
        if (temp == null) {
            System.out.print("Element not found");
            return;
        }
        System.out.print("found: " + temp.value);
    }

    @Override
    public boolean isEmpty() {
        int i = 0;
        while (i < tableSize) {
            if (!list[i].isEmpty()) {
                return list[i].isEmpty();
            }
        }
        return true;
    }
}