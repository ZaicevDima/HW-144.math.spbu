#include <iostream>

using namespace std;

int sumOfDigits(int number)
{
    int tempNumber = abs(number);
    int result = 0;
    while (tempNumber > 0)
    {
        result = result + (tempNumber % 10);
        tempNumber /= 10;
    }
    return result;
}

int searchMaxSumOfDigits(int* numbers, int amount)
{
    int maxSum = 0;
    for (int i = 0; i < amount; i++)
    {
        if (sumOfDigits(numbers[i]) > maxSum)
            maxSum = sumOfDigits(numbers[i]);
    }
    return maxSum;
}

void printNumbers(int* numbers, int amount)
{
    int maxSum = searchMaxSumOfDigits(numbers, amount);
    for (int i = 0; i < amount; i++)
    {
        if (sumOfDigits(numbers[i]) == maxSum)
            cout << numbers[i] << ' ';
    }
}

int main()
{
    int amount = 0;
    cout << "enter amount numbers: \n";
    cin >> amount;
    int* numbers = new int[amount];
    cout << "enter numbers: \n";
    for (int i = 0; i < amount; i++)
        cin >> numbers[i];
    cout << "numbers with a max sum: \n";
    printNumbers(numbers, amount);

    delete[] numbers;
    return 0;
}
