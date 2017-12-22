#include <iostream>

using namespace std;

void sort(int** array, int row, int col)
{
    for (int i = 0; i < col - 1; i++)
    {
        int minIndex = i;
        for (int j = i + 1; j < col; j++)
        {
            if (array[0][j] < array[0][minIndex])
                minIndex = j;
        }

        if (minIndex != i)
        {
            for (int k = 0; k < row; k++)
                swap(array[row][i], array[row][minIndex]);
        }
    }
}

int main()
{
    cout << "enter the number of rows and columns: \n";
    int amountRows = 0;
    int amountColumns = 0;
    cin >> amountRows >> amountColumns;

    int **matrix = new int*[amountRows];
    for (int i = 0; i < amountRows; i++)
        matrix[i] = new int[amountColumns];

    cout << "enter your matrix: \n";
    for (int i = 0; i < amountRows; i++)
        for  (int j = 0; j < amountColumns; j++)
        {
            cin >> matrix[i][j];
        }

    sort(matrix, amountRows, amountColumns);

    for (int i = 0; i < amountRows; i++)
    {
        for  (int j = 0; j < amountColumns; j++)
        {
            cout << matrix[i][j] << ' ';
        }
        cout << "\n";
    }

    for (int i = 0; i < amountRows; i++)
        delete[] matrix;
    delete[] matrix;
    return 0;
}
