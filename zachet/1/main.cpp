#include <iostream>

using namespace std;

void qsort(int* array, int amountElements)
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

int main()
{
    int *numbers = new int[1000];
    int i = 0;
    int newNumber = 0;
    cout << "enter numbers: \n";
    cin >> newNumber;
    while (newNumber != 0)
    {
        numbers[i] = newNumber;
        i++;
        cin >> newNumber;
    }

    qsort(numbers, i - 1);

    if (i != 0)
    {
        int amount = 1;
        cout << numbers[0] << " - ";
        for (int j = 1; j  < i; j++)
        {
            if (numbers[j - 1] == numbers[j])
            {
                amount++;
            }
            else
            {
                cout << amount <<"\n" << numbers[j] << " - ";
                amount = 1;
            }
        }
        cout << amount;
    }
}
