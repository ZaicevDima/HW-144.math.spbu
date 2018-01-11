#include <iostream>
#include <ctime>
#include "operations.h"
using namespace std;
void menu()
{
    cout << "menu: \n";
    cout << "0 - exit \n";
    cout << "1 - fill \n";
    cout << "2 - sort \n";
    cout << "3 - reverse \n";
    cout << "4 - avarage value \n";
}

void printArray(int *array, int size)
{
    for (int i = 0; i < size; i++)
        std::cout << array[i] << ' ';
    std::cout << "\n";
}

int *fillArray(int size, int max, int min)
{
    int *array = new int[size];
    for (int i = 0; i < size; i++)
        array[i] = rand() % max + min;
    return array;
}

void sortArray(int *array, int size)
{
    int middle = size / 2;
    int i = 0;
    int j = size;

    while (i < j)
    {
        while (array[i] < array[middle]){
            i++;
        }
        while (array[j] > array[middle]){
            j--;
        }
        if (i <= j){
            int x = array[i];
            array[i] = array[j];
            array[j] = x;
            i++;
            j--;
        }
    }

    if (j > 0)
        sortArray(array, j);
    if (size > i)
        sortArray(array + i, size - i);
}

void swap(int number1, int number2)
{
    int temp = number1;
    number1 = number2;
    number2 = temp;
}

void reverseArray(int *array, int size)
{
    for (int i = 0; i < size / 2; i++)
        swap(array[i], array[size - i - 1]);
}

double avarageValue(int *array, int size)
{
    if (size == 0)
    {
        return 999999999;
    }
    double sum = 0.0;
    for (int i = 0; i < size; i++)
        sum += (double) array[i];
    return sum / size;
}

