#include <iostream>
#include "matrix.h"

using namespace std;

int **createMatrix(int n, int m)
{
    int **matrix = new int*[n];
    for (int i = 0; i < n; i++)
    {
        matrix[i] = new int[m];
    }
    return matrix;
}

int **fillMatrix(int n, int m, int fill)
{
    int **matrix = createMatrix(n, m);
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            matrix[i][j] = fill;
        }
    }
    return matrix;
}

void scanfMatrix(int **matrix, int n, int m, ifstream &fin)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            fin >> matrix[i][j];
        }
    }
}

void deleteMatrix(int **matrix, int n)
{
    for (int i = 0; i < n; i++)
    {
        delete [] matrix[i];
    }
    delete [] matrix;
}

bool inside(int x, int y, int n, int m)
{
    return (0 <= x) && (x < n) && (0 <= y) && (y < m);
}

void setParent(int **parent, int xParent, int yParent, int xChild, int yChild)
{
    enum parentLocation {up, down, left, right};

    if (xParent == xChild)
    {
        if (yChild > yParent)
            parent[xChild][yChild] = left;
        else
            parent[xChild][yChild] = right;
    }
    else
    {
        if (xChild > xParent)
            parent[xChild][yChild] = up;
        else
            parent[xChild][yChild] = down;
    }
}

int getParent(int **parent, int &x, int &y)
{
    enum parentLocation {up, down, left, right};

    int result = parent[x][y];
    if (result == right)
    {
        y++;
    }
    else if (result == left)
    {
        y--;
    }
    else if (result == down)
    {
        x++;
    }
    else if (result == up)
    {
        x--;
    }

    return result;
}

bool isEqual(int x1, int y1, int x2, int y2)
{
    return (x1 == x2) && (y1 == y2);
}
