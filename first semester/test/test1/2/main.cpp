#include <iostream>
#include "operations.h"

using namespace std;

int main()
{
    menu();
    enum  Command {exit, fill, sort, reverse, avarage};
    int operation = 0;
    cin >> operation;
    int *array = nullptr;
    int size = 0;
    int max = 0;
    int min = 0;
    while (operation){
        switch (operation)
        {
        case exit:
            break;
        case fill:
            cout << "enter size, max value, min value \n";
            cin >> size >> max >> min;
            array = fillArray(size, max, min);
            printArray(array, size);
            break;
        case sort:
            sortArray(array, size - 1);
            printArray(array, size);
            break;
        case reverse:
            reverseArray(array, size);
            printArray(array, size);
            break;
        case avarage:
            cout << avarageValue(array, size) << "\n";
            break;
        }
        cin >> operation;
    }

    delete [] array;
    return 0;
}

