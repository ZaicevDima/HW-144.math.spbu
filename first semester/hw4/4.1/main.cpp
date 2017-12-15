#include <iostream>
#include "stack.h"
using namespace std;

int main()
{
    Stack* spiral = createStack();
    int length = 0;
    cout << "enter length array's ";
    cin >> length;
    while (length % 2 == 0)
    {
        cout << "enter odd length array's \n";
        cin >> length;
    }

    cout << "enter array: \n";
    int **numbers = new int* [length];
    for (int i = 0; i < length; i++)
        numbers[i] = new int [length];
    for (int i = 0; i < length; i++)
        for (int j = 0; j < length; j++)
            cin >> numbers[i][j];

    for (int i = 0; i < length / 2; i++)
    {
            for (int j = i; j < length - i - 1; j++)
                push(spiral, numbers[i][j]);
            for (int j = i; j < length - i - 1; j++)
                push(spiral, numbers[j][length - i - 1]);
            for (int j = i; j < length - i - 1; j++)
                push(spiral, numbers[length - i - 1][length - j - 1]);
            for (int j = i; j < length - i - 1; j++)
                push(spiral, numbers[length - j - 1][i]);
    }
    push(spiral, numbers[length / 2][length / 2]);
    cout << "spyral array: \n";
    while (!isEmpty(spiral))
    {
        cout << top(spiral) <<' ';
        pop(spiral);
    }
    deleteStack(spiral);
    for (int i = 0; i < length; i++)
        delete [] numbers[i];
    delete [] numbers;
    return 0;
}
