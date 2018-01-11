#include <iostream>
#include "list.h"
#include "merge.h"

void mergesort(List *list, int left, int right)
{
    if (left == right)
        return;
    int middle = (left + right) / 2;
    mergesort(list, left, middle);
    mergesort(list, middle + 1, right);
    int i = left;
    int j = middle + 1;
    List *temp = createList();
    for (int step = 0; step < right - left + 1; step++)
    {
        if ((j > right) || (i <= middle) && (valueOfIndex(list, i) < valueOfIndex(list, j)))
        {
            addList(valueOfIndex(list, i), temp);
            i++;
        }
        else
        {
            addList(valueOfIndex(list, j), temp);
            j++;
        }
    }
    for (int step = 0; step < right - left + 1; step++)
        change(list, valueOfIndex(temp, step), left + step);
    deleteList(temp);
}
