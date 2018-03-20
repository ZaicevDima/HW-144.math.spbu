package com.group144.zaicev;

/**
 * Class to work with queue any types
 * @param <Type> - Type which you want use
 */
public class Queue<Type> {
    /** Creating a queue element */
    private class QueueElement {
        Type value;
        int priority;
        QueueElement next;
        QueueElement(Type value, int priority, QueueElement next) {
            this.value = value;
            this.next = next;
            this.priority = priority;
        }
    }

    private QueueElement head = null;
    private QueueElement tail = null;
    private int size = 0;

    /**
     * Method, which add your element to queue
     * @param value - your value
     * @param priority - priority your element
     */
    public void enqueue(Type value, int priority) {
        if (size == 0) {
            head = new QueueElement(value, priority, null);
            tail = head;
            size++;
            return;
        }

        QueueElement newElement = new QueueElement(value, priority, null);
        tail.next = newElement;
        tail = newElement;
        size++;
    }

    /**
     * Method, which remove the element from queue
     * @param value - value, which you want remove
     * @param priority - priority of this element
     */
    private void delete(Type value, int priority) {
        QueueElement previous = null;
        QueueElement current = head;

        while (current != null) {
            if ((current.value == value) && (current.priority == priority)) {
                if (previous != null) {
                    previous.next = current.next;
                    if (current.next == null) {
                        tail = previous;
                    }
                } else {
                    head = head.next;
                    if (head == null) {
                        tail = null;
                    }
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    /**
     * Method, which find and remove element with max priority
     * @return value of the element with max priority
     * @throws QueueIsEmpty if your queue is empty
     */
    public Type dequeue() throws QueueIsEmpty {
        if (size == 0) {
            throw new QueueIsEmpty("Queue is empty");
        }
        QueueElement current = head;
        Type maxValue = null;
        int maxPriority = 0;
        while (current != null) {
            if (current.priority > maxPriority) {
                maxPriority = current.priority;
                maxValue = current.value;
            }
            current = current.next;
        }
        delete(maxValue, maxPriority);
        return maxValue;
    }

    /**
     * Method, which checks whether an element is in the queue
     * @param value - value of the element being checked
     * @param priority - priority of the item being checked
     * @return true, if queue is contains this element, else false
     */
    boolean isContains(Type value, int priority) {
        QueueElement current = head;
        while (current != null) {
            if ((current.value == value) && (current.priority == priority)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
