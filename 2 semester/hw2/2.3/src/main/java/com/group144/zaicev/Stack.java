package com.group144.zaicev;

import java.lang.reflect.Type;

public interface Stack<Type> {
    void push(Type value);
    Type pop();
    Type top();
    boolean isEmpty();
}
