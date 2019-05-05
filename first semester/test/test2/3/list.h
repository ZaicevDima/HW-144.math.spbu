#pragma once

struct ListElement;
struct List;

List *createList();
void addList(int value, List *list);
void clear(List *list);
void deleteList(List *list);
void printList(List *list);
int size(List *list);
void addFirstElement(int value, List *list);
ListElement *ElementOfValue(List *list, int value);
int value(ListElement *element);
void pop(List* list);
int valueOfIndex(List *list, int index);
void change(List *list, int value, int index);
