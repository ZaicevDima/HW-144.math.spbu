#include <iostream>
#include "list.h"

struct ListElement
{
    int value;
    ListElement* next;
    ListElement* previous;
};

struct List
{
    ListElement* head;
    ListElement* end;
    int size;
};

List* createList()
{
    List* newList = new List;
    newList->end = nullptr;
    newList->head = nullptr;
    newList->size = 0;
    return newList;
}

void addFirst(int value, List* list)
{
    ListElement* newElement = new ListElement;
    newElement->value = value;
    newElement->next = nullptr;
    newElement->previous = nullptr;
    list->head = newElement;
    list->end = newElement;
    list->size = 1;
}

void add(int value, List* list)
{
    if (list->size == 0)
    {
        addFirst(value, list);
        return;
    }
    ListElement* newElement = new ListElement;

    newElement->value = value;
    newElement->next = nullptr;
    newElement->previous = list->end;
    list->end->next = newElement;
    list->end = newElement;
    (list->size)++;
}

void pop(List* list)
{
    if (list->size > 1)
    {
        ListElement* tempEnd = list->end;
        tempEnd->previous->next = nullptr;
        list->end = tempEnd->previous;
        delete tempEnd;
    }
    else if (list->size == 0)
        return;
    else
    {
        list->end = nullptr;
        list->head = nullptr;
    }
    list->size--;
}

bool isEmpty(List* list)
{
    return list->head == nullptr;
}

void clear(List* list)
{
    while (list->size > 0)
    {
        pop(list);
    }
}

void deleteList(List* list)
{
    clear(list);
    delete list->end;
    delete list->head;
}

int size(List* list)
{
    return list->size;
}

ListElement* next(ListElement* element)
{
    return element->next;
}

int indexValue(List* list, int index)
{
    if (index < list->size)
    {
        ListElement* currentElement = list->head;
        for (int i = 0; i < index; i++)
            currentElement = next(currentElement);
        return currentElement->value;
    }
}

void printList(List* list)
{
    ListElement* currentElement = list->head;
    for (int i = 0; i < list->size; i++)
    {
        std::cout << currentElement->value <<' ';
        currentElement = next(currentElement);
    }
}
