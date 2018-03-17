package com.group144.zaicev;

public class PolinomialHashFunction implements HashFunction {

    @Override
    public int hash(String stringToHash, int tableSize) {
        int b = 378551;
        int a = 63689;
        int hash = 0;

        for (int i = 0; i < stringToHash.length(); i++) {
            hash = (hash * a + stringToHash.charAt(i)) % tableSize;
            a = (a * b) % tableSize;
        }
        return (hash + tableSize) % tableSize;
    }
}
