package com.group144.zaicev;

public interface List<Type> {
    void delete(Type value) throws NotFoundException;
    boolean contains(Type element);
    void add(Type value) throws ElementIsRepeat;
    int getSize();
    void clear();
    boolean isEmpty();
    Type valueOfIndex(int index);
}
