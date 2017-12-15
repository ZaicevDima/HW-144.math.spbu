#include <iostream>
#include "saddlepoint.h"

using namespace std;


int main()
{
    cout << "enter the dimensions of the matrix \n";
    int n = 0;
    int m = 0;
    cin >> n >> m;
    while (n <= 0 || m <= 0)
    {
        cout << "enter positive numbers: \n";
        cin >> n >> m;
    }

    int **matrix = new int*[n];
    for (int i = 0; i < m; i++)
        matrix[i] = new int [m];

    cout << "enter your matrix: \n";
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> matrix[i][j];

    printSaddlePoint(matrix, n, m);

    for (int i = 0; i < n; i++)
       delete [] matrix[i];
    delete [] matrix;

    return 0;
}
