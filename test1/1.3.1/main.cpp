#include <iostream>
#include <fstream>
#include <string.h>
using namespace std;

void qsort(char* array, int amountElements)
{
    int m = amountElements / 2;
    int i = 0;
    int j = amountElements;

    while (i < j)
    {
        while (array[i] < array[m])
            i++;
        while (array[j] > array[m])
            j--;
        if (i <= j)
        {
            int x = array[i];
            array[i] = array[j];
            array[j] = x;
            i++;
            j--;
        }
    }

    if (j > 0)
        qsort(array, j);
    if (amountElements > i)
        qsort(array + i, amountElements - i);
}

void sortSymbols(int length, char* symbols)
{
    qsort(symbols, length);
    for (int i = 1; i <= length; i++)
        symbols[i - 1] = symbols[i];
}

int main()
{
    ifstream fin;
    ofstream fout;
    fin.open("in.txt");
    fout.open("out.txt");
    if (!fin.good())
    {
        cout << "error, file not opened";
        return 1;
    }

    char* symbols = new char[1000];
    fin.getline(symbols, 1000, '\n');
    int length = strlen(symbols);
    sortSymbols(length, symbols);
    int amount = 1;
    fout << symbols[0] << " - ";
    for (int i = 1; i  < length; i++)
    {
        if (symbols[i - 1] == symbols[i])
            amount++;
        else
        {
            fout << amount <<"\n" << symbols[i] << " - ";
            amount = 1;

        }
    }
    fout << amount;

    delete[] symbols;
    fin.close();
    fout.close();
    return 0;
}
