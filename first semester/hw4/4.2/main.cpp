#include <iostream>
#include <cstring>
#include <fstream>
#include "stack.h"

using namespace std;

ifstream fin;
ofstream fout;

void print(Stack* word)
{
    while (!isEmpty(word))
    {
        fout << top(word);
        pop(word);
    }
    fout << ' ';
}

void printTransformation(Stack* newWord)
{
    char *word = new char[256];
    int i = 0;

    while (!isEmpty(newWord))
    {
        word[i] = top(newWord);
        pop(newWord);
        i++;
    }

    for (int j = 0; j < i; j++)
    {
        push(newWord, word[j]);
        for (int k = i - 1; k >= 0; k--)
        {
            if (word[j] == word[k] && j < k)
            {
                pop(newWord);
                break;
            }
        }
    }
    delete[] word;
}


int main()
{
    fin.open("in.txt");
    fout.open("out.txt");
    if (!fin.good())
    {
        cout << "error, file not opened";
        return 1;
    }
    char *symbols = new char[256];
    while (!fin.eof())
    {
        fin.getline(symbols, 256, ' ');
        int length = strlen(symbols);
        for (int i = 0; i < length; i++)
        {
            int size = i;
            while ((symbols[size] != ' ') && (size < length))
                size++;
            Stack* word = createStack();
            for (int j = i; j < size; j++)
                push(word, symbols[j]);
            printTransformation(word);
            print(word);
            i = size;
        }
    }

    fin.close();
    fout.close();
    deleteStack(word);
    delete[] symbols;
}
