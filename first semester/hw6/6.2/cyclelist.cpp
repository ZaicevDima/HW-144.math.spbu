#include <iostream>
#include "cyclelist.h"

using namespace std;

struct CycleListElement
{
    int value;
    CycleListElement* next;
    CycleListElement* previous;
};

struct CycleList
{
    CycleListElement* head;
    int size;
};

CycleList* createCycle()
{
    CycleList* list = new CycleList;
    return list;
}

void addFirst(int value, CycleList *cycle)
{
    CycleListElement* newElement = new CycleListElement;
    newElement->value = value;
    newElement->next = newElement;
    newElement->previous = newElement;
    cycle->head = newElement;
    cycle->size = 1;
}

void insert(int value, CycleListElement *current, CycleList *cycle)
{
    CycleListElement* tempNext = current->next;
    CycleListElement* newElement = new CycleListElement;
    newElement->value = value;
    newElement->next = tempNext;
    newElement->previous = current;
    current->next = newElement;
    tempNext->previous = newElement;
    cycle->size++;
}

void remove(CycleListElement *current, CycleList *cycle)
{
    current->previous->next = current->next;
    current->next->previous = current->previous;
    if (cycle->head == current)
        cycle->head = current->next;
    delete current;
    cycle->size--;
}

CycleListElement* next(CycleListElement *current)
{
    return current->next;
}

CycleListElement* previous(CycleListElement *current)
{
    return current->previous;
}

CycleListElement* moveNext(CycleListElement *current, int step)
{
    CycleListElement* newCurrent = current;
    for (int i = 0; i < step; i++)
        newCurrent = next(newCurrent);
    return newCurrent;
}

CycleListElement* firstElement(CycleList* cycle)
{
    return cycle->head;
}

int size(CycleList *cycle)
{
    return cycle->size;
}

void printCycle(CycleList *cycle)
{
    CycleListElement* current = firstElement(cycle);
    for (int i = 0; i < size(cycle); i++)
    {
        cout << current->value <<' ';
        current = next(current);
    }
}

void deleteCycle(CycleList *cycle)
{
    while (size(cycle) != 0)
        remove(cycle->head, cycle);
    delete cycle;
}
