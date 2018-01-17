#pragma once

#include <fstream>
#include "mystring.h"

struct HashTable;

const int hashSize = 1499;

HashTable *createTable();
void deleteTable(HashTable *hashTable);

void addToHashTable(HashTable *hashTable, String *string);

double loadFactor(HashTable *hashTable);
double averageLength(HashTable *hashTable);

int amountWords(HashTable *hashTable);
int amountEmptyCells(HashTable *hashTable);

void printMaxCells(HashTable *hashTable);
void printCells(HashTable *hashTable);
