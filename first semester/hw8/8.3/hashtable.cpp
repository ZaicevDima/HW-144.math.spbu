#include <iostream>
#include <fstream>
#include "hashtable.h"
#include "mystring.h"

using namespace std;

struct TableElement
{
    int amountOfWords;
    String *string;
    TableElement* nextElement;
};

struct HashTable
{
    TableElement **cells;
};

HashTable *createTable()
{
    HashTable *newHashTable = new HashTable;
    newHashTable->cells = new TableElement*[tableSize];
    for (int i = 0; i < tableSize; i++)
        newHashTable->cells[i] = nullptr;

    return newHashTable;
}

int hashString(String *stringToHash, int mod)
{
    int const prime = 63689;
    int coefficient = 1;
    int hash = 0;

    for(int i = 0; i < lengthString(stringToHash); i++)
    {
        hash = (hash + ((int)getChar(stringToHash, i) * coefficient) % mod) % mod;
        coefficient = (coefficient * prime) % mod;
    }

    return hash;
}

void addToHashTable(HashTable *hashTable, String *string)
{
    int index = hashString(string, tableSize);
    TableElement* tempElement = hashTable->cells[index];
    while (tempElement != nullptr)
    {
        if (areEqual(tempElement->string, string))
        {
            (tempElement->amountOfWords)++;
            deleteString(string);
            return;
        }
        tempElement = tempElement->nextElement;
    }
    TableElement *newElement = new TableElement;
    newElement->amountOfWords = 1;
    newElement->nextElement = hashTable->cells[index];
    newElement->string = string;
    hashTable->cells[index] = newElement;
}

int amountDifferentWords(HashTable *hashTable)
{
    int amount = 0;
    for (int i = 0; i < tableSize; i++)
    {
        TableElement* tempElement = hashTable->cells[i];
        while (tempElement != nullptr)
        {
            amount++;
            tempElement = tempElement->nextElement;
        }
    }

    return amount;
}

double loadFactor(HashTable *hashTable)
{
    return (double)amountWords(hashTable) / tableSize;
}

int amountWords(HashTable *hashTable)
{
    int amount = 0;
    for (int i = 0; i < tableSize; i++)
    {
        TableElement* tempElement = hashTable->cells[i];
        while (tempElement != nullptr)
        {
            amount += tempElement->amountOfWords;
            tempElement = tempElement->nextElement;
        }
    }

    return amount;
}

int amountEmptyCells(HashTable *hashTable)
{
    int amount = 0;
    for (int i = 0; i < tableSize; i++)
    {
        if (hashTable->cells[i] == nullptr)
            amount++;
    }

    return amount;
}

void printWordsFromCell(HashTable *hashTable, int index,  std::ostream &fout)
{
    TableElement *tempElement = hashTable->cells[index];
    while (tempElement != nullptr)
    {
        printString(tempElement->string, fout);
        fout << ' ' << tempElement->amountOfWords << "\n";
        tempElement = tempElement->nextElement;
    }
}

void printCells(HashTable *hashTable,  ostream &fout)
{
    for (int i = 0; i < tableSize; i++)
        printWordsFromCell(hashTable, i, fout);
}

void printMaxCells(HashTable *hashTable,  ostream &fout)
{
    int maxValue = 0;
    int maxCell = 0;
    for (int i = 0; i < tableSize; i++)
    {
        int current = 0;
        TableElement *tempElement = hashTable->cells[i];
        while (tempElement != nullptr)
        {
            current++;
            tempElement = tempElement->nextElement;
        }
        if (current > maxValue)
        {
            maxValue = current;
            maxCell = i;
        }
    }
    printWordsFromCell(hashTable, maxCell, fout);
}

void deleteCells(TableElement *tableElement)
{
    if (tableElement == nullptr)
        return;

    deleteCells(tableElement->nextElement);
    deleteString(tableElement->string);
    delete tableElement;
}

void deleteTable(HashTable *hashTable)
{
    for (int i = 0; i < tableSize; i++)
        deleteCells(hashTable->cells[i]);

    delete[] hashTable->cells;
    delete hashTable;
}
