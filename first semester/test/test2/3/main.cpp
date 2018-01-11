#include <iostream>
#include "list.h"
#include "merge.h"
using namespace std;

int main()
{
    int amount = 0;
    cout << "enter amount \n";
    cin >> amount;
    List *list = createList();
    for (int i = 0; i < amount; i++)
    {
        int value = 0;
        cin >> value;
        addList(value, list);
    }

    mergesort(list, 0, size(list) - 1);
    cout << "\n";
    printList(list);
    cout << "\n";

    deleteList(list);
    return 0;
}
