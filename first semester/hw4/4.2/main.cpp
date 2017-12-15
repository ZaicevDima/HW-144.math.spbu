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
    char *simbols = new char[256];
    Stack* word = createStack();
    fin.getline(simbols, 256, '\n');
    int length = strlen(simbols);
    for(int i = 0; i < length; i++)
    {
        int size = i;
        while ((simbols[size] != ' ') && (size < length))
            size++;
        Stack* word = createStack();
        for (int j = i;j < size; j++)
            push(word, simbols[j]);
        printTransformation(word);
        print(word);
        i = size;
    }
    deleteStack(word);
    delete[] simbols;
}
