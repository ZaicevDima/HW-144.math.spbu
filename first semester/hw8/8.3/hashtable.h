#pragma once

#include <fstream>
#include "mystring.h"

struct HashTable;

const int tableSize = 1500;

HashTable *createTable();
void deleteTable(HashTable *hastTable);

void addToHashTable(HashTable *hashTable, String *string);

double loadFactor(HashTable *hastTable);
int amountDifferentWords(HashTable *hastTable);
int amountWords(HashTable *hastTable);
int amountEmptyCells(HashTable *hastTable);

void printMaxCells(HashTable *hastTable, std::ostream &fout);
void printCells(HashTable *hastTable, std::ostream &fout);
