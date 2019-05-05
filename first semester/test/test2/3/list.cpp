#include <iostream>
#include "list.h"

struct ListElement
{
    int value;
    ListElement *next;
};

struct List
{
    ListElement *head;
    int size;
};

List *createList()
{
    List *newList = new List;
    newList->head = nullptr;
    newList->size = 0;
    return newList;
}

void addFirstElement(int value, List *list)
{
    ListElement *newElement = new ListElement;
    newElement->next = nullptr;
    newElement->value = value;
    list->head = newElement;
    list->size = 1;
}

void addList(int value, List *list)
{
    if (list->size == 0)
    {
        addFirstElement(value, list);
        return;
    }

    ListElement *newElement = new ListElement;

    newElement->value = value;
    newElement->next = nullptr;
    ListElement *tempElement = list->head;
    while (tempElement->next != nullptr)
        tempElement = tempElement->next;
    tempElement->next = newElement;
    (list->size)++;
}

void printList(List *list)
{
    if (list->size == 0)
        return;

    ListElement *current = list->head;
    while (current->next != nullptr)
    {
        std::cout << current->value << ' ';
        current = current->next;
    }
    std::cout << current->value;
}

int size(List *list)
{
    return list->size;
}

int value(ListElement *element)
{
    return element->value;
}


void pop(List* list)
{
    if (list->size > 1)
    {
        ListElement* temp = list->head;
        while (temp->next->next != nullptr)
        {
            temp = temp->next;
        }
        delete temp->next;
        temp->next = nullptr;
    }
    else if (list->size == 0)
        return;
    else
    {
        delete list->head;
        list->head = nullptr;
    }
    list->size--;
}

void clear(List *list)
{
    while (list->size != 0)
        pop(list);
}

void deleteList(List *list)
{
    clear(list);
    delete list->head;
    delete list;
}

int valueOfIndex(List *list, int index)
{
    ListElement *current = list->head;
    int i = 0;
    while (i != index)
    {
        i++;
        current = current->next;
        //std::cout << "kek \n";
    }
    return current->value;
}

void change(List *list, int value, int index)
{
    ListElement *current = list->head;
    int currentIndex = 0;
    while (currentIndex != index)
    {
        current = current->next;
        currentIndex++;
    }
    current->value = value;
}
