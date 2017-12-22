#include <iostream>

using namespace std;

void sort(int **array, int row, int col)
{
    for (int i = 0; i < col - 1; i++)
    {
        for (int j = 0; j < col - i - 1; j++)
        {
            if (array[0][j] > array[0][j + 1])
            {
                for (int i = 0; i < row; i++)
                {
                    int temp = array[i][j];
                    array[i][j] = array[i][j + 1];
                    array[i][j + 1] = temp;
                }
            }
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
    cout << "sort matrix: \n";

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
