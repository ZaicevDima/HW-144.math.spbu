package com.group144.zaicev;

/** exception, if your value not found */
class ValueNotFoundException extends Exception {
    ValueNotFoundException(String massege) {
        super(massege);
    }
}
