#include <iostream>
#include "sort.h"

using namespace std;

int main()
{
    int length = 0;
    cout << "enter length arrays ";
    cin >> length;
    int array[1000] = {0};
    cout << "enter array \n";
    for (int i = 0; i < length; i++)
        cin >> array[i];
    sort(length - 1, array);

    int i = length - 1;

    while (i > 0)
    {
        if (array[i] == array[i - 1])
        {
            cout << array[i];
            break;
        }
        i--;
    }
    return 0;
}
