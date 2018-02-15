#pragma once
#include "mystring.h"

const int maxSize = 10000;

struct List;

List *create();

void addInList(List *list, String *string);
void deleteList(List *list);
void print(List *list);

bool isEmptyString(List *list);
int sizeList(List *list);
