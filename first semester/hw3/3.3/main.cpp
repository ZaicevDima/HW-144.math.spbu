#include <iostream>
#include "sort.h"

using namespace std;

int amountOfDigits(int number)
{
    int amound = 0;
    while (number > 0)
    {
        number /= 10;
        amound++;
    }
    return amound;
}

void decomositionOfDigits(int size, int* array)
{
    int i = 0;
    while(size > 0)
    {
        array[i] = size % 10;
        size /= 10;
        i++;
    }
}

int main()
{
    int number = 0;
    cout << "enter the number ";
    cin >> number;
    int digit[100] = {0};
    int quantityOfDigits = amountOfDigits(number);
    decomositionOfDigits(number, digit);
    sort(quantityOfDigits - 1, digit);
    cout << "\n";
    int i = 0;
    cout << "minimum number = ";
    while (i < quantityOfDigits)
    {
        if (digit[i] != 0)
            cout << digit[i];
        i++;
    }
    return 0;
}
