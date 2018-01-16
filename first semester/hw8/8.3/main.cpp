#include <iostream>
#include <fstream>
#include "hashtable.h"
#include "mystring.h"

using namespace std;

const int maxSize = 10000;

int main()
{
    ifstream fin;
    fin.open("input.txt");
    if (!fin.good())
    {
        cout << "Error,file is not found\n";
        return 1;
    }

    HashTable *hashTable = createTable();

    char *newWord = new char[maxSize];
    while (!fin.eof())
    {
        fin >> newWord;
        String *newLine = createString(newWord);
        addToHashTable(hashTable, newLine);
    }

    cout << "Words and their frequencies: \n";
    printCells(hashTable);
    cout << "Load factor " << loadFactor(hashTable) << "\n";
    cout << "Maximal cell: \n";
    printMaxCells(hashTable);
    cout << "Amount of words: " << amountWords(hashTable) << "\n";
    cout << "Amount of empty cells: " << amountEmptyCells(hashTable) << "\n";
    cout << "Average chain length: " << averageLength(hashTable) << "\n";

    fin.close();
    delete [] newWord;
    deleteTable(hashTable);
    return 0;
}
