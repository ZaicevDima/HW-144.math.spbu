#include <iostream>

using namespace std;

int biggest(int size1, int size2, bool* number1, bool* number2)
{
    if (size1 > size2)
        return 1;
    if (size1 < size2)
        return 2;
    for (int i = size1 - 1; i >= 0; i--)
    {
        if (number1[i])
        {
            if (!number2[i])
                return 1;
        }
        else
        {
            if (number2[i])
                return 2;
        }
    }
    return 0;
}

int main()
{
    int size1 = 0;
    int size2 = 0;
    cout << "enter size first and second number: \n";
    cin >> size1 >> size2;
    bool* firstNumber = new bool [size1];
    bool* secondNumber = new bool [size2];
    cout << "enter first number: \n";
    for (int i = 0; i < size1; i++)
        cin >> firstNumber[i];
    cout << "enter second number: \n";
    for (int i = 0; i < size2; i++)
        cin >> secondNumber[i];
    int result = biggest(size1, size2, firstNumber, secondNumber);
    if (result == 1)
        cout << "first number > second number";
    if (result == 2)
        cout << "first number < second number";
    if (result == 0)
        cout << "first number = second number";
}
