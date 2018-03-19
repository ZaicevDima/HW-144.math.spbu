package com.group144.zaicev;

/** length hash function */
public class LengthHashFunction implements HashFunction {
    @Override
    public int hash(String value, int mod) {
        return value.length() % mod;
    }
}
