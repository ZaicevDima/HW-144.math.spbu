#include <iostream>
#include "cyclelist.h"

using namespace std;

int main()
{
    cout << "enter amount warriors and murder period: \n";
    int n = 0;
    int m = 0;
    cin >> n >> m;

    CycleList* wars = createCycle();
    addFirst(0, wars);
    CycleListElement* current = firstElement(wars);
    for (int i = 1; i < n; i++)
    {
        insert(i, current, wars);
        current = next(current);
    }

    current = firstElement(wars);
    int amountNow = size(wars);
    while (amountNow > 1)
    {
        current = moveNext(current, m);
        CycleListElement* prev = previous(current);
        remove(current, wars);
        current = prev;
        amountNow--;
    }
    cout << "The last warrior is ";
    printCycle(wars);

    deleteCycle(wars);
    return 0;
}
