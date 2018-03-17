package com.group144.zaicev;

import java.lang.String;

public interface HashTableInterface {
    void add(String value);
    void delete(String value) throws ValueNotFound;
    void getInformation();
    void findValue(String value);
    boolean isEmpty();
}
