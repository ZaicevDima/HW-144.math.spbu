#include <iostream>
#include <fstream>
#include "hashtable.h"
#include "mystring.h"
#include "list.h"

using namespace std;

struct HashTable
{
    int size;
    int amountWords;
    List **cells;
};

HashTable *createTable()
{
    HashTable *newTable = new HashTable;
    newTable->size = hashSize;
    newTable->amountWords = 0;

    newTable->cells = new List*[newTable->size];
    for (int i = 0; i < newTable->size; i++)
        newTable->cells[i] = create();

    return newTable;
}

int hashString(String *stringToHash)
{
    int const prime = 63689;
    int mod = hashSize;
    int hash = 0;
    int coefficient = 1;

    for (int i = 0; i < lengthString(stringToHash); i++)
    {
        hash = (hash + ((int)getChar(stringToHash, i) * coefficient) % mod) % mod;
        coefficient = (coefficient * prime) % mod;
    }

    return hash;
}

void addToHashTable(HashTable *hashTable, String *string)
{
    int index = hashString(string);
    (hashTable->amountWords)++;
    addInList(hashTable->cells[index], string);
}

int amountDifferentWords(HashTable *hashTable)
{
    int amount = 0;
    for (int i = 0; i < hashTable->size; i++)
    {
        if (!isEmptyString(hashTable->cells[i]))
        {
            amount++;
        }
    }

    return amount;
}

double loadFactor(HashTable *hashTable)
{
    return (double)amountDifferentWords(hashTable) / hashTable->size;
}

int amountWords(HashTable *hashTable)
{
    return hashTable->amountWords;
}

int amountEmptyCells(HashTable *hashTable)
{
    return hashTable->size - amountWords(hashTable);
}

void printCells(HashTable *hashTable)
{
    for (int i = 0; i < hashTable->size; i++)
    {
        if (!isEmptyString(hashTable->cells[i]))
        {
            print(hashTable->cells[i]);
        }
    }
}

void printMaxCells(HashTable *hashTable)
{
    int maxValue = 0;
    int maxCell = 0;
    for (int i = 0; i < hashTable->size; i++)
    {
        if (sizeList(hashTable->cells[i]) > maxValue)
        {
            maxValue = sizeList(hashTable->cells[i]);;
            maxCell = i;
        }
    }
    print(hashTable->cells[maxCell]);
}

void deleteTable(HashTable *hashTable)
{
    for (int i = 0; i < hashTable->size; i++)
        deleteList(hashTable->cells[i]);

    delete[] hashTable->cells;
    delete hashTable;
}

double averageLength(HashTable *hashTable)
{
    int result = 0;
    for (int i = 0; i < hashTable->size; i++)
        result += sizeList(hashTable->cells[i]);

    return (double) result / amountDifferentWords(hashTable);
}
