#pragma once
#include <iostream>

struct ListElement;
struct List;

List* createList();
void add(int value, List* list);
void pop(List* list);
bool isEmpty(List* list);
void clear(List* list);
void deleteList(List* list);
int size(List* list);
ListElement* next(ListElement* element);
int indexValue(List* list, int index);
void printList(List* list);
