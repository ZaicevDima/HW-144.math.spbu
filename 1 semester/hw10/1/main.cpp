#include <iostream>
#include <fstream>
#include "matrix.h"
#include "astar.h"

using namespace std;

int main()
{
    ifstream fin("input.txt");
    if (!fin.good())
    {
        cout << "Error, file didn't open";
        return 1;
    }

    int n = 0;
    int m = 0;
    fin >> n >> m;

    int xStart = 0;
    int yStart = 0;
    cout << "Enter start point x([0..n - 1]) and y([0..m - 1]) \n";
    cin >> xStart >> yStart;

    int xFinish = 0;
    int yFinish = 0;
    cout << "Enter finish point x and y \n";
    cin >> xFinish >> yFinish;

    int **matrix = fillMatrix(n, m, 0);
    scanfMatrix(matrix, n, m, fin);

    int **used = fillMatrix(n, m, 0);
    int **distance = fillMatrix(n, m, inf);
    int **parent = fillMatrix(n, m, -1000);
    int **heuristic = fillMatrix(n, m, inf);
    int **currents = fillMatrix(n, m, 0);

    aStar(matrix, used, distance, parent, heuristic, currents, n, m, xStart, yStart, xFinish, yFinish);

    deleteMatrix(matrix, n);
    deleteMatrix(used, n);
    deleteMatrix(distance, n);
    deleteMatrix(parent, n);
    deleteMatrix(currents, n);
    deleteMatrix(heuristic, n);
    fin.close();
    return 0;
}
