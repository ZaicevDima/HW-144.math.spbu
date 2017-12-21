#include <iostream>
#include "saddlepoint.h"

using namespace std;

bool minInString(int index, int value, int** matrix, int n, int m)
{
    for (int i = 0; i < m; i++)
    {
        if (matrix[index][i] < value)
            return false;
    }
    return true;
}

bool maxInColumn(int index, int value, int** matrix, int n, int m)
{
    for (int i = 0; i < n; i++)
    {
        if (matrix[i][index] > value)
            return false;
    }
    return true;
}

bool isSaddlePoint(int index1, int index2, int** matrix, int n, int m)
{
    int value = matrix[index1][index2];
    return (minInString(index1, value, matrix, n, m) && maxInColumn(index2, value, matrix, n, m));
}

void printSaddlePoint(int** matrix, int n, int m)
{
    cout << "Saddles Point:\n";
    int amount = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (isSaddlePoint(i, j, matrix, n, m))
            {
                cout << i << ' ' << j << " value this point = " << matrix[i][j] << "\n";
                amount++;
            }
        }
    }
    if (amount == 0)
        cout << "there are no such points";
}
