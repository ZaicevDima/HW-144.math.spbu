package com.group144.zaicev;

/** polynomial hash function */
public class PolynomialHashFunction implements HashFunction {

    @Override
    public int hash(String stringToHash, int mod) {
        int b = 378551;
        int a = 63689;
        int hash = 0;

        for (int i = 0; i < stringToHash.length(); i++) {
            hash = (hash * a + stringToHash.charAt(i)) % mod;
            a = (a * b) % mod;
        }
        return (hash + mod) % mod;
    }
}
