#include <iostream>
#include "list.h"

using namespace std;

int main()
{
    List* list = createList();
    for (int i = 0; i < 5; i++)
        add(i, list);
    pop(list);
    printList(list);
    cout << "index" << indexValue(list, 2);
    deleteList(list);
    return 0;
}
