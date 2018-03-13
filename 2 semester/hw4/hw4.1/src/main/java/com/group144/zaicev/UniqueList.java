package com.group144.zaicev;

import java.lang.reflect.Type;

public class UniqueList<Type> extends ListLinked<Type> {

    UniqueList() {
        super();
    }

    @Override
    public void add(Type value) throws ElementIsRepeat {
        if (this.contains(value)) {
            throw new ElementIsRepeat("Element is repeat");
        }
        super.add(value);
    }


}
