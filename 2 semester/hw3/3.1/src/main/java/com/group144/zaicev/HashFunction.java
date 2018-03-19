package com.group144.zaicev;

/**
 *  Interface for choice hash function
 */
public interface HashFunction {
    int hash(String value, int mod);
}
