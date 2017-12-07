#pragma once

struct CycleListElement;
struct CycleList;

CycleList* createCycle();
void deleteCycle(CycleList* cycle);
void addFirst(int value, CycleList* cycle);
void insert(int value, CycleListElement* current, CycleList *cycle);
void remove(CycleListElement* current, CycleList *cycle);
int getValue(CycleListElement* current);
int size(CycleList* cycle);
void printCycle(CycleList* cycle);
CycleListElement* next(CycleListElement* current);
CycleListElement* previous(CycleListElement* current);
CycleListElement* moveNext(CycleListElement* current, int step);
CycleListElement* firstElement(CycleList* cycle);
