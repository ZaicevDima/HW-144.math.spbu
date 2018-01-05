#include <iostream>
#include <fstream>
#include "hashtable.h"
#include "mystring.h"

using namespace std;

bool isDelimiter(char symbol)
{
    return (symbol == ' ') || (symbol == '\n') || (symbol == '.') ||
           (symbol == ',') || (symbol == ';')  || (symbol == '\0');
}

void addWords(HashTable *hastTable, String *string)
{
    int beginningOfWord = 0;
    int endOfWord = 0;
    int currentIndex = 0;
    while (currentIndex < lengthString(string))
    {
        currentIndex = endOfWord;
        while ((currentIndex < lengthString(string)) && (isDelimiter(getChar(string, currentIndex))))
            currentIndex++;
        beginningOfWord = currentIndex;

        while ((currentIndex < lengthString(string)) && (!isDelimiter(getChar(string, currentIndex))))
            currentIndex++;
        endOfWord = currentIndex;

        if (beginningOfWord < endOfWord)
            addToHashTable(hastTable, subString(string, beginningOfWord, endOfWord - beginningOfWord));
    }
    deleteString(string);
}

int main()
{
    ifstream fin;
    fin.open("input.txt");
    if (!fin.good())
    {
        cout << "Error,file is not found\n";
        return 1;
    }

    HashTable *hastTable = createTable();

    while (!fin.eof())
    {
        String *newLine = inputString(fin);
        addWords(hastTable, newLine);
    }

    cout << "Words and their frequencies: \n";
    printCells(hastTable, cout);
    cout << "Load factor " << loadFactor(hastTable) << "\n";
    cout << "Maximal cell: \n";
    printMaxCells(hastTable, cout);
    cout << "Amount of words: " << amountWords(hastTable) << "\n";
    cout << "Amount of empty cells: " << amountEmptyCells(hastTable) << "\n";

    fin.close();
    deleteTable(hastTable);
    return 0;
}
