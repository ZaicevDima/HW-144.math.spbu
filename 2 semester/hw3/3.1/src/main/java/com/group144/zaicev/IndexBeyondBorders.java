package com.group144.zaicev;

/**
 *  exception, if the index is out of bounds
 */
class IndexBeyondBorders extends Exception {
    IndexBeyondBorders(String massege) {
        super(massege);
    }
}
