package com.group144.zaicev;

/** Throw if queue is empty */
class QueueIsEmpty extends Throwable {
    QueueIsEmpty(String message) {
        super(message);
    }
}
