package com.group144.zaicev;

public class LengthHashFunction implements HashFunction {

    @Override
    public int hash(String value, int sizeHashTable) {
        return value.length() % sizeHashTable;
    }
}
