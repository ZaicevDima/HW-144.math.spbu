package com.group144.zaicev;

/**
 *  exception, if the index is out of bounds
 */
class IndexBeyondBordersException extends Exception {
    IndexBeyondBordersException(String massege) {
        super(massege);
    }
}
