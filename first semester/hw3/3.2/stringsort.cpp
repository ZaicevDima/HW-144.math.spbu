#include <iostream>
#include "stringsort.h"

void sort(int size, char* array)
{
    int mid = size / 2;
    int left = 0;
    int right = size;

    while (left < right)
    {
        while (array[left] < array[mid])
        {
            left++;
        }
        while (array[right] > array[mid])
        {
            right--;
        }
        if (left <= right)
        {
            std::swap(array[left], array[right]);
            left++;
            right--;
        }
    }

    if (right > 0)
        sort(right, array);
    if (size > left)
        sort(size - left, array + left);
}

